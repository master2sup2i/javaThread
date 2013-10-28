package Voitures;

public class UtilEmploye 
{
	public static void main (String[] args)
	{
		Employe e1, e2, e3;
		e1 = new Employe ("Lafleur","Jimmy","23-03-1991","128, grande rue, La tronche","04/12/12","Administrateur");
		e2 = new Employe ("Lafleur","Dominique","16 Avril 1991","Rue Joliot Curie","04/12/12","Chanteur");
		e3 = new Employe ("Lafleur","Paul","23-03-1991","Cours duoret","04/12/12","Parleur");
		e1.Afficher();
		e2.Afficher();
		e3.ModifierNom("Deroud");
		e3.Afficher();
	}
	
	
	
	
	
}
