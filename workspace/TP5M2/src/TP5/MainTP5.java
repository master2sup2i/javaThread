package TP5;

public class MainTP5 {

	/*
	 ******** Main TP5 *******
	*/
	/*
	public static void main(String[] args) {
		TP5	fact =new TP5(); 
		System.out.println("10 factoriel");
	      for(int i=0;i<=10;i++) {
	      System.out.println(i+"! est "+fact.factoriel(i)); 
	      }
	}
	*/
	
	/*
	 ******** Main TP5Thread ********
	*/
	
	public static void main(String[] args){
		long debut;
		long fin; 
		long duree;
		debut=System.currentTimeMillis();
		TP5Thread fact = new TP5Thread (1,10,2);
		fact.start();
		try {
			fact.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fin=System.currentTimeMillis();
		duree=fin-debut;
		System.out.println(fact.res);
		System.out.println("temps traitement: "+duree);
	}
}
