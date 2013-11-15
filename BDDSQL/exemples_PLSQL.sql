connect scott/tiger@orcl
Si scott LOCKED
connect system/tiger@orcl
ALTER USER scott ACCOUNT UNLOCK;
connect scott/tiger@orcl

===============================================================================
set serveroutput on
DECLARE
	nom scott.emp.ename%TYPE;
	salaire scott.emp.sal%TYPE;
	CURSOR C1 IS SELECT ename, NVL(sal,0) FROM SCOTT.emp;
BEGIN
	OPEN C1;
	LOOP
		FETCH C1 INTO nom, salaire;
		EXIT WHEN C1%NOTFOUND;
		DBMS_OUTPUT.PUT_LINE ( nom||' gagne '||salaire || ' dollars');
	END LOOP;
	CLOSE C1;
END;

/

SMITH gagne 800 dollars
ALLEN gagne 1600 dollars
WARD gagne 1250 dollars
JONES gagne 2975 dollars
MARTIN gagne 1250 dollars
BLAKE gagne 2850 dollars
CLARK gagne 2450 dollars
SCOTT gagne 3000 dollars
KING gagne 5000 dollars
TURNER gagne 1500 dollars
ADAMS gagne 1100 dollars
JAMES gagne 950 dollars
FORD gagne 3000 dollars
MILLER gagne 1300 dollars

ProcÚdure PL/SQL terminÚe avec succÞs.
===============================================================================
-- Idem avec une boucle loop sur les enregisterements
BEGIN
	FOR record_emp IN (SELECT * FROM scott.EMP)
	LOOP
		DBMS_OUTPUT.PUT_LINE(record_emp.ename||' gagne '||record_emp.sal || ' Dollars');
	END LOOP;
END;
 
/
===============================================================================

    DBMS_OUTPUT.GET_LINES (lignes OUT tableau_char, nombre_lignes IN OUT INTEGER)
/*
tableau_char représente un tableau de chaînes de caractères. La taille maximum de chaque ligne est de 255 caractères
nombre_lignes en entrée représente le nombre de lignes du tampon que l'on souhaite lire.
En sortie, il indique le nombre de lignes effectivement lues depuis le tampon

Exemple 
*/
SQL> set serveroutput on;
Declare                                                      
   CURSOR C_EMP Is                                           
   Select * From SCOTT.EMP ;                                       
Begin                                                        
   -- Ouverture du tampon --                                 
   DBMS_OUTPUT.ENABLE( 1000000 ) ;                           
   -- Boucle sur la table EMP --                             
   For C in C_EMP Loop                                       
      -- Ligne avec caractère fin de ligne --                
      DBMS_OUTPUT.PUT_LINE( 'Employé -> ' || C.EMPNO ) ;     
      -- Ligne composée de différents champs --              
      DBMS_OUTPUT.PUT( ' ' || 'Nom=' || C.ENAME ) ;          
      DBMS_OUTPUT.PUT( ' ' || 'Job=' || C.JOB ) ;            
      DBMS_OUTPUT.PUT( ' ' || 'Dept=' || C.DEPTNO ) ;        
      DBMS_OUTPUT.PUT( ' ' || 'Salaire=' || C.SAL ) ;        
      -- Saut de ligne --                                    
      DBMS_OUTPUT.NEW_LINE ;                                 
   End loop ;                                                
End ;                                                        
/

Employé -> 7369
Nom=SMITH Job=CLERK Dept=20 Salaire=800
Employé -> 7499
Nom=ALLEN Job=SALESMAN Dept=30 Salaire=1600
Employé -> 7521
Nom=WARD Job=SALESMAN Dept=30 Salaire=1250
Employé -> 7566
Nom=JONES Job=MANAGER Dept=20 Salaire=2975
Employé -> 7654
Nom=MARTIN Job=SALESMAN Dept=30 Salaire=1250
Employé -> 7698
Nom=BLAKE Job=MANAGER Dept=30 Salaire=2850
Employé -> 7782
Nom=CLARK Job=MANAGER Dept=10 Salaire=2450
Employé -> 7788
Nom=SCOTT Job=ANALYST Dept=20 Salaire=3000
Employé -> 7839
Nom=KING Job=PRESIDENT Dept=10 Salaire=5000
Employé -> 7844
Nom=TURNER Job=SALESMAN Dept=30 Salaire=1500
Employé -> 7876
Nom=ADAMS Job=CLERK Dept=20 Salaire=1100
Employé -> 7900
Nom=JAMES Job=CLERK Dept=30 Salaire=950
Employé -> 7902
Nom=FORD Job=ANALYST Dept=20 Salaire=3000
Employé -> 7934
Nom=MILLER Job=CLERK Dept=10 Salaire=1300

ProcÚdure PL/SQL terminÚe avec succÞs.
===============================================================================

SQL> CREATE DIRECTORY FICHIERS_IN AS 'C:\Tools\Oracle\Cours\fichiers\in';
Répertoire créé.
SQL> GRANT READ ON DIRECTORY FICHIERS_IN TO PUBLIC ;
Autorisation de privilèges (GRANT) acceptée.
SQL> CREATE DIRECTORY FICHIERS_OUT AS 'C:\Tools\Oracle\Cours\fichiers\out';
Répertoire créé.
SQL> GRANT READ, WRITE ON DIRECTORY FICHIERS_OUT TO PUBLIC ;
Autorisation de privilèges (GRANT) acceptée.

-- Exemple:
-- Ouverture d'un fichier en lecture et écriture du contenu dans un autre
SQL> 
Declare
	-- Noms des fichiers --
	LC$Fic_in Varchar2(128) := 'exemple_SQL.txt' ; -- a adapter sur votre configuration
	LC$Fic_out Varchar2(128) := 'EMP2.TXT' ; -- a adapter sur votre configuration
	-- Noms des répertoires --
	LC$Dir_in Varchar(100) := 'FICHIERS_IN'; -- a adapter sur votre configuration
	LC$Dir_out Varchar(100) := 'FICHIERS_OUT' ; -- a adapter sur votre configuration
	-- Pointeurs de fichier --
	LF$FicIN UTL_FILE.FILE_TYPE ;
	LF$FicOUT UTL_FILE.FILE_TYPE ;
	-- Tampon de travail --
	LC$Ligne Varchar2(32767) ;
	-- Message --
	LC$Msg Varchar2(256) ;
	-- Exception --
	LE$Fin Exception ;
Begin
	-- Ouverture du fichier en entrée
	Begin
		LF$FicIN := UTL_FILE.FOPEN( LC$Dir_in, LC$Fic_in, 'R', 32764 ) ;
	Exception
		When OTHERS Then
			LC$Msg := SQLERRM || ' [' || LC$Dir_in || '] -> ' || LC$Fic_in;
			Raise LE$Fin ;
	End ;
	-- Ouverture du fichier en sortie
	Begin
		LF$FicOUT := UTL_FILE.FOPEN( LC$Dir_out, LC$Fic_out, 'W', 32764 ) ;
	Exception
		When OTHERS Then
				LC$Msg := SQLERRM || ' [' || LC$Dir_out || '] -> ' || LC$Fic_out;
				Raise LE$Fin ;
	End ;
	-- Traitement --
	Begin
		Loop
			-- lecture du fichier en entrée --
			UTL_FILE.GET_LINE( LF$FicIN, LC$Ligne ) ;
			-- écriture du fichier en sortie --
			UTL_FILE.PUT_LINE( LF$FicOUT, LC$Ligne ) ;
		End loop ;
	Exception
		When NO_DATA_FOUND Then -- Fin du fichier en entrée
		-- Fermeture des fichiers --
		UTL_FILE.FCLOSE( LF$FicIN ) ;
		UTL_FILE.FCLOSE( LF$FicOUT ) ;
	End ;
Exception
	When LE$Fin Then
		UTL_FILE.FCLOSE_ALL ;
		RAISE_APPLICATION_ERROR( -20100, LC$Msg ) ;
End ;

===============================================================================

EXEMPLE 2 : Extraction d'une table dans un fichier

CREATE OR REPLACE PROCEDURE Extraction_Table
(
		PC$Table in Varchar2, -- Nom de la table a extraire
		PC$Fichier in Varchar2, -- Nom du fichier de sortie
		PC$Repertoire in Varchar2, -- Nom du directory de sortie
		PC$Separateur in Varchar2 Default ',', -- Caractere de separation
		PC$Entetes in Varchar2 Default 'O', -- Affichage de l'entete des
		colonnes
		PC$DateFMT in Varchar2 Default 'DD/MM/YYYY', -- Format des dates
		PC$Where in Varchar2 Default Null, -- Clause Where de filtrage
		PC$Order in Varchar2 Default Null -- Colonne de tri
) IS
LF$Fichier UTL_FILE.FILE_TYPE ;
LC$Ligne Varchar2(32767) ;
LI$I Integer ;
LC$DateFMT Varchar2(40) := '''' || PC$DateFMT || '''' ;
TYPE REFCUR1 IS REF CURSOR ;
cur REFCUR1;
-- Colonnes de la table --
CURSOR C_COLTAB ( PC$Tab IN VARCHAR2 ) IS
	SELECT
		COLUMN_NAME,
		DATA_TYPE
	FROM
		USER_TAB_COLUMNS
	WHERE
	TABLE_NAME = PC$Tab
	AND
	DATA_TYPE IN ('CHAR','VARCHAR2','NUMBER','DATE','FLOAT');
LC$Separateur Varchar2(2) := PC$Separateur ;
LC$Requete Varchar2(10000) ;
LC$Desc Varchar2(10000) ;
LC$SQLW VARCHAR2(10000):= 'SELECT ';
LC$Col VARCHAR2(256);
-----------------------------------------
-- Ouverture d'un fichier d'extraction --
-----------------------------------------
FUNCTION Ouvrir_fichier
(
	PC$Dir in Varchar2,
	PC$Nom_Fichier in Varchar2
	) RETURN UTL_FILE.FILE_TYPE
IS
Fichier UTL_FILE.FILE_TYPE ;
LC$Msg Varchar2(256);
Begin
	Fichier := UTL_FILE.FOPEN( PC$Dir, PC$Nom_Fichier, 'W', 32764 ) ;
	If not UTL_FILE.IS_OPEN( Fichier ) Then
		LC$Msg := 'Erreur ouverture du fichier (' || PC$Dir || ') ' || PC$Nom_Fichier ;
		RAISE_APPLICATION_ERROR( -20100, LC$Msg ) ;
	End if ;
	Return( Fichier ) ;
Exception
When UTL_FILE.INVALID_PATH Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'File location is invalid.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_MODE Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The open_mode parameter in FOPEN is
	invalid.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_FILEHANDLE Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'File handle is invalid.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_OPERATION Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'File could not be opened or operated on as
	requested.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.READ_ERROR Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'Operating system error occurred during the
	read operation.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.WRITE_ERROR Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'Operating system error occurred during the
	write operation.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INTERNAL_ERROR then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'Unspecified PL/SQL error';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
---------------------------------------------------------------
-- Les exceptions suivantes sont spécifiques à la version 9i --
-- A mettre en commentaire pour une version antérieure --
---------------------------------------------------------------
When UTL_FILE.CHARSETMISMATCH Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'A file is opened using FOPEN_NCHAR,'
	|| ' but later I/O operations use nonchar functions such as PUTF or GET_LINE.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.FILE_OPEN Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The requested operation failed because the file is open.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_MAXLINESIZE Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The MAX_LINESIZE value for FOPEN() is invalid;'
	|| ' it should be within the range 1 to 32767.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_FILENAME Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The filename parameter is invalid.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.ACCESS_DENIED Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'Permission to access to the file location is
	denied.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.INVALID_OFFSET Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The ABSOLUTE_OFFSET parameter for FSEEK() is
	invalid;'
	||' it should be greater than 0 and less than the total number of bytes in the file.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.DELETE_FAILED Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The requested file delete operation
	failed.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
When UTL_FILE.RENAME_FAILED Then
	LC$Msg := PC$Dir || PC$Nom_Fichier || ' : ' || 'The requested file rename operation
	failed.';
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
-----------------------------------------------------------------
-- Les exceptions précédentes sont spécifiques à la version 9i --
-- mettre en commentaire pour une version antérieure --
-----------------------------------------------------------------
When others Then
	LC$Msg := 'Erreur : ' || To_char( SQLCODE ) || ' sur ouverture du fichier ('
	|| PC$Dir || ') ' || PC$Nom_Fichier ;
	RAISE_APPLICATION_ERROR( -20070, LC$Msg ) ;
End Ouvrir_fichier ;
Begin
	-- Ouverture du fichier --
	LF$Fichier := Ouvrir_fichier( PC$Repertoire, PC$Fichier ) ;
	-- Affichage des entetes de colonne ? --
	If Upper(PC$Entetes) = 'O' Then
		LI$I := 1 ;
		For COLS IN C_COLTAB( PC$Table ) Loop
			If LI$I = 1 Then
				LC$Ligne := LC$Ligne || COLS.COLUMN_NAME ;
			Else
				LC$Ligne := LC$Ligne || LC$Separateur || COLS.COLUMN_NAME ;
			End if ;
			LI$I := LI$I + 1 ;
		End loop ;
		-- Ecriture ligne entetes --
		UTL_FILE.PUT_LINE( LF$Fichier, LC$Ligne ) ;
	ElsIf Upper(PC$Entetes) = 'I' Then
		LC$Separateur := ',' ;
		LC$Desc := 'INSERT INTO ' || PC$Table || ' (' ;
		LI$I := 1 ;
		For COLS IN C_COLTAB( PC$Table ) Loop
			If LI$I = 1 Then
				LC$Desc := LC$Desc || COLS.COLUMN_NAME ;
			Else
				LC$Desc := LC$Desc || LC$Separateur || COLS.COLUMN_NAME ;
			End if ;
			LI$I := LI$I + 1 ;
		End loop ;
		LC$Desc := LC$Desc || ' ) VALUES (' ;
	End if ;
-- Construction de la requete --
	LI$I := 1 ;
	FOR COLS IN C_COLTAB( PC$Table ) LOOP
		IF LI$I > 1 THEN
			LC$SQLW := LC$SQLW || '||' ;
		END IF ;
		If COLS.DATA_TYPE IN ('NUMBER','FLOAT') Then
			LC$Col := 'Decode(' || COLS.COLUMN_NAME || ',NULL, ''NULL'',To_char("'
			|| COLS.COLUMN_NAME || '"))' ;
		ElsIf COLS.DATA_TYPE = 'DATE' Then
			If Upper(PC$Entetes) = 'I' Then
				LC$Col := 'Decode(' || COLS.COLUMN_NAME || ',NULL,''NULL'',''to_date(''''''||'
				|| 'To_char("' || COLS.COLUMN_NAME || '",'|| LC$DateFMT ||')' || '||'''''','''||
				LC$DateFMT||''')'')' ;
			Else
				LC$Col := 'To_char("'|| COLS.COLUMN_NAME || '",'|| LC$DateFMT ||')' ;
			End if ;
		Else
		If Upper(PC$Entetes) = 'I' Then
			LC$Col := 'Decode(' || COLS.COLUMN_NAME || ',NULL, ''NULL'',' || ''''''''''
			|| '|| REPLACE("'|| COLS.COLUMN_NAME || '",CHR(39),CHR(39)||CHR(39))' || '||' ||
			''''''''')' ;
		Else
			LC$Col := '"'|| COLS.COLUMN_NAME || '"' ;
		End if ;
		End if ;
		IF LI$I = 1 THEN
			LC$SQLW := LC$SQLW || LC$Col ;
		ELSE
			LC$SQLW := LC$SQLW || '''' || LC$Separateur || '''' || '||' || LC$Col ;
		END IF ;
		LI$I := LI$I + 1 ;
	END LOOP ;
	LC$Requete := LC$SQLW || ' FROM ' || PC$Table ;
	If PC$Where is not null Then
		-- ajout de la clause WHERE --
		LC$Requete := LC$Requete || ' WHERE ' || PC$Where ;
	End if ;
	If PC$Order is not null Then
		-- ajout de la clause ORDER BY --
		LC$Requete := LC$Requete || ' ORDER BY ' || PC$Order ;
	End if ;
	F_TRACE( LC$Requete, 'T' ) ;
	-- Extraction des lignes --
	Open cur For LC$Requete ;
	Loop
		Fetch cur Into LC$Ligne ;
		Exit when cur%NOTFOUND ;
		-- Ecriture du fichier de sortie --
		If Upper(PC$Entetes) = 'I' Then
			UTL_FILE.PUT_LINE( LF$Fichier, LC$Desc || LC$Ligne || ' );' ) ;
		Else
			UTL_FILE.PUT_LINE( LF$Fichier, LC$Ligne ) ;
		End if ;
	End loop ;
	Close cur ;
	-- Fermeture fichier --
	UTL_FILE.FCLOSE( LF$Fichier ) ;
End ;

============================================================================
CREATE OR REPLACE PROCEDURE F_TRACE (pc$message IN VARCHAR2, pc$output IN VARCHAR2 DEFAULT 'S')
IS
   PRAGMA AUTONOMOUS_TRANSACTION;
   lc$string   VARCHAR2 (4000);
   LN$slices   PLS_INTEGER;
   LN$rest     PLS_INTEGER;
   LN$pos      PLS_INTEGER     := 1;
   LN$inc      PLS_INTEGER;
BEGIN
   IF UPPER (pc$output) = 'S'
   THEN
      -- Screen output (DBMS_OUTPUT) --
      LN$inc := 255;
      LN$slices := LENGTH (pc$message) / LN$inc;
      LN$rest := MOD (LENGTH (pc$message), LN$inc);
 
      IF LN$rest > 0
      THEN
         LN$slices := LN$slices + 1;
      END IF;
 
      -- output --
      FOR i IN 1 .. LN$slices
      LOOP
         lc$string := SUBSTR (pc$message, LN$pos, LN$inc);
         DBMS_OUTPUT.PUT_LINE (lc$string);
         LN$pos := LN$pos + LN$inc;
      END LOOP;
   ELSE
      -- Table output (INSERT) --
      LN$inc := 4000;
      LN$slices := LENGTH (pc$message) / LN$inc;
      LN$rest := MOD (LENGTH (pc$message), LN$inc);
 
      IF LN$rest > 0
      THEN
         LN$slices := LN$slices + 1;
      END IF;
 
      -- output --
      FOR i IN 1 .. LN$slices
      LOOP
         lc$string := SUBSTR (pc$message, LN$pos, LN$inc);
 
         INSERT INTO TRACE
                     (ligne
                     )
              VALUES (lc$string
                     );
 
         COMMIT;
         LN$pos := LN$pos + LN$inc;
      END LOOP;
   END IF;
END;


-- create table TRACE (ligne VARCHAR2(4000));