package TestAbonne;

public class Abonne {
	
	String Nom; 
	int NumeroAbonne;
	int AncienIndex, NouvelIndex;
	
    public Abonne(String n, int Nro, int AncienIndex, int NouvelIndex)
    { Nom = n ; 
      NumeroAbonne = Nro;
      this.AncienIndex = AncienIndex ;
      this.NouvelIndex = NouvelIndex ;
    }
    
    public float TotalaPayer()
    { int  Conso = NouvelIndex - AncienIndex;
      float total = 10 ; 
      if (Conso <= 100)
      { total += Conso*0.12;}
      else
    	  if (Conso <=250) // 100< Conso <= 250
    	  { total += 100*0.12 + (Conso-100)*0.08;}
    	  else
    	  { total += 100*0.12 + 150*0.08 + (Conso-250)*0.05;};
      return total;
    }

    
}