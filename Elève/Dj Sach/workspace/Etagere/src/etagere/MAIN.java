package etagere;

public class MAIN {
	
	 public static void main(String[] args)
	  {  
		 Livre L1 = new Livre("Victor Hugo", "Notre Dame de Paris");
	     L1.setNbPages(150);
	     L1.setPrix(80.0);
	     Livre L2 = new Livre("Emile Zola", "La bête humaine");
	     L2.setNbPages(170);
	     L2.setPrix(150.0);
	     Livre L3 = new Livre("Emile Zola", "La bête humaine");
	     L3.setNbPages(380);
	     L3.setPrix(50.0);
	     System.out.print("Livre de " + L1.getAuteur());
	     System.out.println(" avec " + L1.getNbPages() + " pages.");
	     System.out.print("Livre de " + L2.getAuteur());
	     System.out.println(" avec " + L2.getNbPages() + " pages.");
	     System.out.println(L1);
	     System.out.println(L2);
	     
//etagere
	     Etagere E1 = new Etagere(1);
//ajouter livre + exception
	     try
	     {E1.ajouterlivre(L1);
	     System.out.println("le livre a été ajouté dans l'étagère");}
	     catch(EtagerePleine e)
	     {System.out.println("Le livre ne peut pas etre ajouté..");}
	     
	     try
	     {E1.ajouterlivre(L2);
	     System.out.println("le livre a été ajouté dans l'étagère");}
	     catch(EtagerePleine e)
	     {System.out.println("Le livre ne peut pas etre ajouté..");}
	          
//recuperer livre
	     Livre L = E1.recuplivre(1);
	     if (L == null)
	     {
	    	 System.out.println("le livre qu'on veut récupérer n'existe pas !!");
	     }
	     else 
	     {
	    	 System.out.println("le livre cherché est " + L.getTitre() + ". Il a été écrit par " + L.getAuteur() + " et fait " + L.getNbPages()+ " pages.");
	     }
	     
//chercher livre
	     
	     int C= E1.cherchelivre("Emile Zola", "La bête humaine");  
	     if (C == -1)
	     {
	    	 System.out.println("le livre cherché n'existe pas.");
	     }
	     else
	     {
	    	 System.out.println("le lire cherché est à la position : " + E1.cherchelivre("Emile Zola", "La bête humaine"));
	     }

//chercher livre renvoi tableau
	     int R[]=E1.chercher("Emile Zola", "La bête humaine");
	     for (int i=0;i<R.length;i++)
	     {
	    	 if (R[i] != 0)
	    	 {
	    		 System.out.println("'Avec tableau'.. Position du livre : " + R[i]);
	    	 }
	     }
	     
//supprimer livre methode 1
	     



//Description Etagere
	 System.out.println(E1.toString());
	  }
}
		