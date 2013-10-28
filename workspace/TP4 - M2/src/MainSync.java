
public class MainSync {

	public static void main(String[] args) {
		    int[] t = {5, 8, 3, 2, 7, 10, 1, 9, 25};
		    TreadSync trieur = new TreadSync(t,0,8, null);
		    trieur.start();
			try {
				trieur.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    trieur.afficher();   
	}
}


