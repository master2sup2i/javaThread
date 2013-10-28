import java.util.Random;


public class Compteur extends Thread {

	private int fin;
	private String nom;
	private int cpt; 
	private static Object synchro = new Object();
	
	public Compteur (String nom, int fin) {
		
		this.fin = fin;
		this.nom = nom;
		
	}
	
	public void run() {
		for (int i=1;i<fin; i++)
		{
			System.out.println ("Le compteur " + nom + " = "+i);
			Random r=new Random(0);
			try
			{
				sleep(r.nextInt(5000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		synchronized(synchro){
		System.out.println(nom + " a fini de compter en position " +fin );
		}
	}		
	
}
