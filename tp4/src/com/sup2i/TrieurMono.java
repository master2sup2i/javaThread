package com.sup2i;
/**
 * Tri d'un tableau d'entiers
 * Version mono-thread
 */
public class TrieurMono {
  /**
   * Tableau à trier.
   */
  private int[] t;
  
  public TrieurMono(int[] t) {
    this.t = t;
  }
  /**
   * Trie le tableau d'entiers par ordre croissant
   */
  public void trier() {
    trier(0, t.length - 1);
  }
  /**
   * Trie le tableau d'entiers passé en paramètre.
   * @param t tableau à trier
   */
  public void trier(int[] t) {
    this.t = t;
    trier();
  }
  /**
   * Trie une tranche de t
   * @param debut indice du début de la partie à trier
   * @param debut indice de la fin de la partie à trier
   */
  private void trier(int debut, int fin) {
    if (fin - debut < 2) {
      if (t[debut] > t[fin]) {
        echanger(debut, fin);
      }
    }
    else {
      int milieu = debut + (fin - debut) / 2;
      trier(debut, milieu);
      trier(milieu + 1, fin);
      triFusion(debut, fin);
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

 /*
  public static void main(String[] args) {
    int[] t = {5, 8, 3, 2, 7, 10, 1};
    TrieurMono trieur = new TrieurMono(t);
    trieur.trier();
    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }
    System.out.println();
    t = new int[] {25, 36, 6, 25, 3};
    trieur.trier(t);
    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }    
  }*/
}