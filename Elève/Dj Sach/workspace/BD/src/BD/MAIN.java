package BD;

import java.sql.SQLException;


public class MAIN 
{  public static void main (String[] args)
   {  try
      { Base f = new Base();
 
      	f.ajouterEleve("Julieto","Maramé","Yuzka");
        f.FirstRequete();
        //f.modifierEleve(nomE, prenomE, VilleE);
        f.FirstRequete();
        //f.DeuxiemeRequete();
        //f.TroisiemeRequete();   
        //f.QuatriemeRequete();
        //f.CinquiemeRequete();
        //f.SixiemeRequete(); 
        //f.Close();
      }
      catch (SQLException e)
      { System.out.println(e.getMessage());}
      
   }
}
