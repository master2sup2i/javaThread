package TestCompteur;

public class Compteur {

	int Compteur;
	
	public Compteur()
	{
		Compteur = 0;
	}
	
	public void Inc()
	{
		Compteur ++;
	}
	
	public void Dec()
	{
		Compteur --;
	}
	
	public int getCompteur()
	{
		return Compteur;
	}
	
}
