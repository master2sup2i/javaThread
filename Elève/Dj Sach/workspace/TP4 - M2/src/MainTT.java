
public class MainTT {

	public static void main(String[] args) {
		    int[] t = {5, 8, 3, 2, 7, 10, 1, 9, 25};
		    TrierThread trieur = new TrierThread(t,0,8);
		    trieur.start();
		    try {
				trieur.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    trieur.afficher();    
	}
}


