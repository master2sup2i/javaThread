package PremierTest;

public class MAIN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int y = 556 ;
		String S=("abc2c4c5cdefghijkl") ;
		
	    //System.out.println( testing.fact(y));
	    //System.out.println( "Le nombre est-il paire? " + testing.parite(y));
	    //System.out.println( "Est-il divisible par 5 ou 7? " + testing.divisible(y));
	    //System.out.println( "Quelle est l'appréciation? " + testing.notation(y));
	    //System.out.println( "Somme des chiffres : " + testing.somme(y));
	    System.out.println( "Liste en ordre inverse : " + testing2.listinverse(S));
	    System.out.println( "Compte les lettres de la chaîne :" + S.length());
	    System.out.println( "C appartient à la chaine S ?? " + testing2.appartientoupas(S, 'c'));
	    System.out.println( "Compte le nombre de lettres 'c' :" + testing2.comptechar(S, 'c'));
	    //System.out.println( "Somme des chiffres : " + testing2.somme(S));
	    
	}
	
	

}
