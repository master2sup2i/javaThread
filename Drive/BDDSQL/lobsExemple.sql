Create table t_test (id_clob number, texte clob); 
INSERT INTO t_test VALUES (1,'Hello World'); 
INSERT INTO t_test VALUES (2,rpad('*',32000,'*')); 
COMMIT; 
SELECT * FROM t_test; 


CREATE OR REPLACE PROCEDURE insert_test (p_id NUMBER, p_text VARCHAR2) IS 
	v_clob CLOB; 
BEGIN 
	-- On insere la ligne avec un CLOB vide 
	INSERT INTO t_test VALUES (p_id, empty_clob()) returning 	texte into v_clob;  -- On le rempli avec un contenu 
	DBMS_LOB.WRITE(v_clob, 1, length(p_text),p_text); 
	COMMIT; 
END; 
/

-- Ou en plus simple…

CREATE OR REPLACE PROCEDURE insert_test (p_id NUMBER, p_text CLOB) IS 
BEGIN 
	INSERT INTO t_test VALUES (p_id, p_text); 	
	COMMIT; 
END; 
/

------------------------------------
CONNECT system / tiger

CREATE directory blobdir AS 'c:\temp\'; 

GRANT READ ON directory blobdir TO scott;

Connect scott/tiger
------------------------------------

-- On crée une table qui contiendra nos images 
CREATE TABLE t_blob (id number, image blob);

-- Création du package

CREATE OR REPLACE PACKAGE sql_blob IS 
-- Procédure servant à ajouter un BLOB à notre table. 
-- p_id correspond à l'id 
-- p_name correspond au nom du fichier à inserer. 
PROCEDURE add_blob(p_id NUMBER, p_name VARCHAR2); 
PROCEDURE write_blob(p_id NUMBER, p_name VARCHAR2);
END sql_blob; 
/ 

CREATE OR REPLACE PACKAGE BODY sql_blob IS 
PROCEDURE add_blob(p_id NUMBER, p_name VARCHAR2) IS 
	v_blob BLOB; 
	v_bfile BFILE; 
BEGIN
	 -- On insére la ligne avec un blob vide dont on récupère le pointeur 
	INSERT INTO t_blob 
	VALUES (p_id, empty_blob()) 
	RETURNING image INTO v_blob; 
	-- On déclare un pointeur vers notre fichier 
	v_bfile := bfilename(directory => 'BLOBDIR', filename => p_name);
	 -- On ouvre ce fichier 
	dbms_lob.fileopen(v_bfile); 
	-- On rempli l'emplacement du BLOB vide dans la table avec le contenu de 	   notre fichier 	
	dbms_lob.loadfromfile(v_blob, v_bfile, dbms_lob.getlength(v_bfile));
	 -- On ferme le fichier 
	dbms_lob.fileclose(v_bfile); 
END;

PROCEDURE write_blob(p_id NUMBER, p_name VARCHAR2) IS 
	v_file utl_file.file_type; 
	v_repertoire VARCHAR2(512) := 'C:\Oracle\dirOut'; 
	v_fichier VARCHAR2(256) := p_name; 
	v_buffer RAW(32000); 
	v_offset PLS_INTEGER DEFAULT 1; 
	v_taille PLS_INTEGER; 
	v_longueur PLS_INTEGER; 
	v_chunk PLS_INTEGER; 
	v_blob BLOB; 
BEGIN 
	-- On récupére le BLOB 
	SELECT image INTO v_blob FROM t_blob WHERE id = 1; 
	-- On l'ouvre en lecture afin de pouvoir le parser plus facilement 	
	dbms_lob.OPEN(v_blob, dbms_lob.lob_readonly);
	 -- On regarde la taille de Chunk idéale 
	v_chunk := dbms_lob.getchunksize(v_blob);
	--longueur  du blob
	v_longueur := dbms_lob.getlength(v_blob);  
	-- On crée le fichier sur le disque dur 
	v_file := utl_file.fopen(v_repertoire, v_fichier, 'w', 32767); 
	-- On ecrit dans le fichier tant que l'on a pas fait tout le BLOB 
	WHILE v_offset < v_longueur LOOP 
		IF v_longueur - (v_offset - 1) > v_chunk THEN 
			v_taille := v_chunk; 
		ELSE 
			v_taille := v_longueur - (v_offset - 1); 
		END IF; 
		v_buffer := NULL; 
		-- On lit la partie du BLOB qui nous interesse 					
		dbms_lob.READ(v_blob, v_taille, v_offset, v_buffer); 
		-- On ecrit cette partie dans le fichier 
		utl_file.put(file => v_file, 
			   buffer => utl_raw.cast_to_varchar2(v_buffer)); 
		utl_file.fflush(file => v_file); 
		v_offset := v_offset + v_taille;
 END LOOP; 
 	 -- On ferme le BLOB 
	dbms_lob.CLOSE(v_blob); 
	-- On ferme le fichier 
	utl_file.fclose(v_file);

EXCEPTION WHEN OTHERS THEN 
	IF dbms_lob.ISOPEN(v_blob) = 1 THEN 
		dbms_lob.CLOSE(v_blob); 
	END IF; 
	IF utl_file.is_open(file => v_file) THEN 
		utl_file.fclose(file => v_file); 
	END IF; 

END;
END sql_blob; 
/

-- MonImage.bmp doit etre dans le répertoire BLOBDIR
exec sql_blob.add_blob(1,'MonImage.bmp');

exec sql_blob.write_blob(1,'MonImage2.bmp');

-------------------------------------------------------
BFILES
-------------------------------------------------------
/*
Nous allons ensuite créer notre table qui nous servira à contenir nos pointeurs de type BFILE. 
*/
CREATE TABLE t_bfile (id number, filename bfile);

/*
Ensuite voici la commande qui va permettre de rajouter une ligne avec un pointeur vers un fichier HWorld.txt (contenant hello world). 
*/
INSERT INTO t_bfile VALUES (1, bfilename('BLOBDIR', 'HWorld.txt')); 
COMMIT;

CREATE OR REPLACE FUNCTION blob_to_char(p_file IN BFILE) 
RETURN VARCHAR2 AS 
	v_raw RAW(4000); 
	v_bfile BFILE DEFAULT p_file; 
BEGIN 
	-- On ouvre notre fichier désigné par notre pointeur
 	dbms_lob.fileopen(v_bfile); 
	-- On récupère les 4000 premiers caractères 	
	v_raw := dbms_lob.substr(v_bfile, 4000, 1); 
	-- On fermer notre fichier 
	dbms_lob.fileclose(v_bfile);
	 -- On converti notre buffer en VARCHAR2 
	RETURN utl_raw.cast_to_varchar2(v_raw); 
END; 
/

SELECT blob_to_char(filename) 
      FROM t_bfile 
     WHERE id=1;

