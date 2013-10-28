package TestSansDoublons;

public class GestionTableau 
{ int[] T ; 
  int finT ;
  
  public GestionTableau( int[] T)
  { this.T = T;
    finT = T.length ;
  }
	
  public void AfficherSansDoublons()
  { int i, j ;
    boolean Trouve ;
    
    for (i = 0; i< finT ; i++)
    {  Trouve = false ;
        for (j = i+1 ; ((j < finT) && (!Trouve)); j++)
        {  Trouve = T[i]==T[j] ; } // or if (T[i]==T[j] Trouve=true
        if (!Trouve)
        {System.out.print(T[i] + " ");}
    }
    System.out.println();
  }

}
