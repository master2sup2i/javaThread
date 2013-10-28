	public class TreadSync extends Thread
	{
		  /**
		   * Tableau � trier.
		   */
		  private int[] t;
		  private int debut, fin;
		  private TreadSync pere;
		  private boolean finish;
		  
		  public TreadSync(int[] t, int debut, int fin, TreadSync pere ) 
		  {
		    this.t = t;
		    this.debut = debut;
		    this.fin = fin;
		    this.pere = pere;
		  }
		  
		  public synchronized void run() {
		    if (fin - debut < 2) {
		      if (t[debut] > t[fin]) {
		        echanger(debut, fin);
		      }
		    }
		    else {
		      int milieu = debut + (fin - debut) / 2;
		      TreadSync T1 = new TreadSync (t,debut,milieu,this);
		      TreadSync T2 = new TreadSync (t,milieu+1,fin,this);
		      T1.start();
		      T2.start();
		      while (!T1.finish || !T2.finish){		    	  
		      try {
				wait();
				} 
		      catch (InterruptedException e) 
		      {
				e.printStackTrace();
		      }
		      }
		      triFusion(debut, fin);
		    }
		    finish=true;
		    if (pere !=null) {
		    	synchronized (pere)
		    	{
		    		pere.notify();
		    	}
		    }
		  }
		  /**
		   * Echanger t[i] et t[j]
		   */

		  private void echanger(int i, int j) {
		    int valeur = t[i];
		    t[i] = t[j];
		    t[j] = valeur;
		  }
		  /**
		   * Fusionne 2 tranches d�j� tri�es du tableau t.
		   *   - 1�re tranche : de debut � milieu
		   *   - 2�me tranche : de milieu + 1 � fin
		   * @param milieu indique le dernier indice de la 1�re tranche
		   */

		  public void afficher (){
			  for (int i = 0; i <t.length; i++) {
			      System.out.print(t[i] + " ; ");
			    }
		  }
		  
		  private void triFusion(int debut, int fin) {
		    // tableau o� va aller la fusion
		    int[] tFusion = new int[fin - debut + 1];
		    int milieu = (debut + fin) / 2;
		    // Indices des �l�ments � comparer
		    int i1 = debut,i2 = milieu + 1;
		    // indice de la prochaine case du tableau tFusion � remplir
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
		      // la 1�re tranche est �puis�e
		      for (int i = i2; i <= fin; ) {
		        tFusion[iFusion++] = t[i++];
		      }
		    }
		    else {
		      // la 2�me tranche est �puis�e
		      for (int i = i1; i <= milieu; ) {
		        tFusion[iFusion++] = t[i++];
		      }
		    }
		    // Copie tFusion dans t
		    for (int i = 0, j = debut; i <= fin - debut; ) {
		      t[j++] = tFusion[i++];
		    }
		  }
		 
	
}
