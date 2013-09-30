package com.sup2i;
/**
 * Tri d'un tableau d'entiers
 * Version mono-thread
 */
public class TrieurMultiThread extends Thread {
	/**
	 * Tableau à trier.
	 */
	private int[] t;
	private int debut;
	private int fin;


	public TrieurMultiThread(int[] t, int deb, int fin) {
		this.t = t;
		this.debut = deb;
		this.fin = fin;
	}
	/*
	 * Trie une tranche de t
	 * @param debut indice du début de la partie à trier
	 * @param debut indice de la fin de la partie à trier
	 */
	public void run() {
		if (fin - debut < 2) {
			if (t[debut] > t[fin]) {
				echanger(debut, fin);
			}
		}
		else {
			int milieu = debut + (fin - debut) / 2;

			TrieurMultiThread trieur1 = new TrieurMultiThread(t, debut, milieu);
			TrieurMultiThread trieur2 = new TrieurMultiThread(t, milieu+1, fin);

			trieur1.start();
			trieur2.start();

			try {
				trieur1.join();
				trieur2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			triFusion(debut, fin);
		}
	}

	/**
	 * Fusionne 2 tranches déjà triées du tableau t.
	 *   - 1ère tranche : de debut à milieu
	 *   - 2ème tranche : de milieu + 1 à fin
	 * @param milieu indique le dernier indice de la 1ère tranche
	 */
	public void triFusion(int debut, int fin) {
		// tableau où va aller la fusion
		int[] tFusion = new int[fin - debut + 1];
		int milieu = (debut + fin) / 2;
		// Indices des éléments à comparer
		int i1 = debut, 
				i2 = milieu + 1;
		// indice de la prochaine case du tableau tFusion à remplir
		int iFusion = 0;
		while (i1 <= milieu && i2 <= fin) {
			if (t[i1] < t[i2]) {
				tFusion[iFusion++] = t[i1++];
			}
			else {
				tFusion[iFusion++] = t[i2++]; 
			}
		}
		if (i1 > milieu) {
			// la 1ère tranche est épuisée
			for (int i = i2; i <= fin; ) {
				tFusion[iFusion++] = t[i++];
			}
		}
		else {
			// la 2ème tranche est épuisée
			for (int i = i1; i <= milieu; ) {
				tFusion[iFusion++] = t[i++];
			}
		}
		// Copie tFusion dans t
		for (int i = 0, j = debut; i <= fin - debut; ) {
			t[j++] = tFusion[i++];
		}
	}

	/**
	 * Echanger t[i] et t[j]
	 */
	public void echanger(int i, int j) {
		int valeur = t[i];
		t[i] = t[j];
		t[j] = valeur;
	}


}