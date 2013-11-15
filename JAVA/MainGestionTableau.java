package TestSansDoublons;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{ int[] T1={3,4,6,9};
	  int[] T2={3,4,6,4,7};
	  GestionTableau gT1 = new GestionTableau(T1);
	  GestionTableau gT2 = new GestionTableau(T2);
	  gT1.AfficherSansDoublons();
	  gT2.AfficherSansDoublons();
      	}

}
