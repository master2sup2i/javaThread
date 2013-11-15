CREATE OR REPLACE PACKAGE PkgTool

 AUTHID CURRENT_USER IS

 /*----------------------------------------*/
 /*               TYPES                    */
 /*----------------------------------------*/

	TYPE array IS TABLE OF VARCHAR2(32767) INDEX BY BINARY_INTEGER;



  PROCEDURE split( pString IN VARCHAR2, pSep IN CHAR, pOut IN OUT array);
  
END;
/

CREATE OR REPLACE PACKAGE BODY PkgTool IS


  PROCEDURE split( pString IN VARCHAR2, pSep IN CHAR, pOut IN OUT array)
  IS
	BEGIN
		select regexp_substr(pString,'[^' || pSep || ']+', 1, level) 
			bulk collect into pOut 
		from dual
			connect by regexp_substr(pString,'[^' || pSep || ']+', 1, level) is not null; 
  END;
END;
/

DECLARE
		p  PkgTool.array;	 
	begin
		PkgTool.split('SMITH,ALLEN,WARD,JONES',',', p); 			
	  FOR i IN 1 .. p.COUNT LOOP
	    dbms_output.put_line(p(i));
	  END LOOP;
	end;
	/
	