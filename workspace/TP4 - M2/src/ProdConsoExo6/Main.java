package ProdConsoExo6;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Buffer b = new Buffer();
        Produc p1 = new Produc(b);
        Conso c1 = new Conso(b,"Jean");
        p1.start();
        c1.start();
        p1.join();
        c1.join();   
	}

}
