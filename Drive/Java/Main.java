package TestAbonne;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{ Abonne Martine = new Abonne("Merlin", 1012, 220, 1440); 
	  Abonne Marcelo = new Abonne("Marcelo", 1023, 1300, 1540); 
	  Abonne Pepe    = new Abonne("Pepe", 1050, 3400, 3550);
	      
	  System.out.println (Martine.TotalaPayer());
	  System.out.println (Marcelo.TotalaPayer());
	  System.out.println (Pepe.TotalaPayer());
	}
}
