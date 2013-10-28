package Voitures;

public class Employe 
{
	String Nom;
	String Prenom;
	String Date;
	String Adresse;
	String Datembauche;
	String Postoccupe;
	
	public Employe (String n, String p, String date, String adr, String datemb, String postoc)
	{
		Nom = n;
		Prenom = p;
		Date = date;
		Adresse = adr;
		Datembauche = datemb;
		Postoccupe = postoc;
	}
	
	public void Afficher()
	{
		System.out.println ( "L'employé "+Nom+" "+Prenom+", né le "+Date+" et habitant au "+Adresse+", occupe le poste de "+Postoccupe+" depuis le "+Datembauche);
	}
	
	public void ModifierNom(String n)
	{
		Nom = n;
	}
}
