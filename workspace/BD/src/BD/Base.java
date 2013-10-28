package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {
  Connection  cnx;
  public Base() throws SQLException
  { try
    { Class.forName("com.mysql.jdbc.Driver").newInstance();
      try 
      { cnx = DriverManager.getConnection("jdbc:mysql://localhost/TestBDJava",
  		  "root", ""); 
        System.out.println("ouverture avec succes " + cnx.getCatalog());
      }
      catch (SQLException ex)
      { System.out.println(ex.getMessage() + ex.getErrorCode() + ex.getSQLState());
        throw ex;
      }
    }
	catch (Exception e)
	{ System.out.println("Error ouverture Driver " + e.getMessage());}
  }
  
  public void FirstRequete()
  { Statement stmt = null;
	ResultSet res = null;
	try 
	{ stmt = cnx.createStatement();
	  res = stmt.executeQuery("select * from Eleve");}
	catch ( SQLException e)
	{ System.out.println ("error requete" + e.getMessage());}
	try
	{ while(res.next())
	  { System.out.println("---------------------------");
	    System.out.println("ID Eleve:     " + res.getInt("IdEleve"));
	    System.out.println("Nom Eleve:    " + res.getString("NomEleve"));
	    System.out.println("Prenom Eleve: " + res.getString("PrenomEleve"));
	  }
	}
	catch (SQLException ex)
	{ System.out.println(ex.getMessage());}
  }
  
  public void DeuxiemeRequete()
  { Statement stmt = null;
	ResultSet res = null;
	try 
	{ stmt = cnx.createStatement();
	  if (stmt.execute("select * from Enseignant"))
	  { res = stmt.getResultSet();
	    while(res.next())
	    { System.out.println("---------------------------");
	      System.out.println("ID Enseignant:  " + res.getInt("IdEnseignant"));
	      System.out.println("Nom Enseignant: " + res.getString("NomEnseignant"));
	      System.out.println("Ville:     " + res.getString("VilleEnseignant"));
	    }
	  }
	  else
	  {System.out.println("modification de la BD");
	   System.out.println("Nbre enregistrement modifies" + stmt.getUpdateCount());
	  }
	}
	catch ( SQLException e)
	{ System.out.println ("error requete" + e.getMessage());}
	
  }
  
  public void TroisiemeRequete()
  { Statement stmt = null;
	int[] Resultat;
	try 
	{ stmt = cnx.createStatement();
	  stmt.addBatch("UPDATE cours SET Semestre = 1 WHERE IdCours = 2");
	  stmt.addBatch("UPDATE Enseignant SET VilleEnseignant = 'Poisat' WHERE IdEnseignant = 3");
	  Resultat = stmt.executeBatch();
	  for (int i = 0; i < Resultat.length; i++)
	  { switch (Resultat[i])
		{ case Statement.EXECUTE_FAILED:
		  { System.out.println ("L'instruction " + i + " a echoue");
		    break;
		  }
		  case Statement.SUCCESS_NO_INFO:
		  { System.out.println ("L'instruction " + i + " a reussi");
		    break;
		  }	  
		  default: 
		  { System.out.println ("L'instruction " + i + " a reussi");
		    System.out.println ("elle a modifie " + Resultat[i] + " donnees");
		  }
		}
	   }
	}
	catch ( SQLException e)
	{ System.out.println ("error batch " + e.getMessage());}
  }
  
  public void QuatriemeRequete()
  { Statement stmt = null;
	ResultSet res = null;
	int i=1; 
	try 
	{ stmt = cnx.createStatement();
	  if (stmt.execute("select * from Eleve where IdEleve = \'" + i + "\'"))
	  { res = stmt.getResultSet();
	    System.out.println ("Les eleves");
	    while(res.next())
	    { System.out.println("---------------------------");
	      System.out.println("ID Eleve:  " + res.getInt("IdEleve"));
	      System.out.println("Nom Eleve: " + res.getString("NomEleve"));
	      System.out.println("Ville:     " + res.getString("VilleEleve"));
	    }
	  }
	  else 
	  { System.out.println("Nothing selected");}
	}
	catch ( SQLException e)
	{ System.out.println ("Error requete " + e.getMessage());}
  }
  
  public void CinquiemeRequete()
  { PreparedStatement stmt = null;
	ResultSet res = null;
	int i=1; 
	try 
	{ stmt = cnx.prepareStatement("select * from Eleve where IdEleve = ? ", 
			                      ResultSet.TYPE_SCROLL_SENSITIVE, 
			                      ResultSet.CONCUR_UPDATABLE);
	  stmt.setInt(1, i);
	  if ( stmt.execute())
	  { res = stmt.getResultSet();
	    while (res.next())
	    { System.out.println ("Les eleves");
	      System.out.println("---------------------------");
	      System.out.println("ID Eleve:  " + res.getInt("IdEleve"));
	      System.out.println("Nom Eleve: " + res.getString("NomEleve"));
	      System.out.println("Ville:     " + res.getString("VilleEleve")); 
	      res.updateString("VilleEleve", "Clermont"); 
	      res.updateRow(); // mettre
	    }
	  }
	  else 
	  { System.out.println("Nothing selected");}
	}
	catch ( SQLException e)
	{ System.out.println ("Error requete " + e.getMessage());}
	try 
	{ if (res.first()) {System.out.println(res.getString("VilleEleve"));} } 
	catch(Exception e){System.out.println("uff");}
  }
  
  public void SixiemeRequete()
  { CallableStatement stmt = null;
	ResultSet res = null;
	String Ville = "Fontaine";  
	try 
	{ stmt = cnx.prepareCall("{call SelectionEleves(?)}");
	  stmt.setString(1, Ville);
	  if ( stmt.execute())
	  { res = stmt.getResultSet();
	    while (res.next())
	    { System.out.println ("Les eleves");
	      System.out.println("---------------------------");
	      System.out.println("ID Eleve:  " + res.getInt("IdEleve"));
	      System.out.println("Nom Eleve: " + res.getString("NomEleve"));
	      System.out.println("Ville:     " + res.getString("VilleEleve")); 
	    }
	  }
	  else 
	  { System.out.println("Nothing selected");}
	}
	catch ( SQLException e)
	{ System.out.println ("Error requete " + e.getMessage());}
  }
 
  //ajouter eleve
  public void ajouterEleve(String nomE, String prenomE, String VilleE )
  {
	  PreparedStatement stmt = null;
	  
	  try{
		  stmt = cnx.prepareStatement("insert into eleve (NomEleve, PrenomEleve, VilleEleve)values (?, ?, ?)");
		  stmt.setString(1,nomE);
		  stmt.setString(2,prenomE);
		  stmt.setString(3,VilleE);
		  if (! stmt.execute())
		  {
			  System.out.println("Eleve ajouté !!");
		  }
	  }
	  catch (SQLException e)
	  {
		  System.out.println("Pas de valeurs..");
	  }
	  
  }
  
  //modifier eleve
  
  
  public void Close()
	{ try
	  { cnx.close(); }
	  catch (SQLException e)
	  { System.out.println ("La BD reste dans un etat inconnu");}
  }
}
	

