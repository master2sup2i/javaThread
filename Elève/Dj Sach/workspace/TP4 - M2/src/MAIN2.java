
public class MAIN2 {

	public static void main(String[] args) {
	    int[] t = {5, 8, 3, 2, 7, 10, 1, 9};
	    Tripara trieur = new Tripara(t,2,9);
	    trieur.start();
	    trieur.trier();
	    for (int i = 0; i <t.length; i++) {
	      System.out.print(t[i] + " ; ");
	    }
	    System.out.println();
	    t = new int[] {25, 36, 6, 25, 3, 26, 8};
	    trieur.trier(t);
	    for (int i = 0; i <t.length; i++) {
	      System.out.print(t[i] + " ; ");
	    }    
	  }
}

