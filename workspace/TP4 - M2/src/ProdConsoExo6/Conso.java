package ProdConsoExo6;


public class Conso extends Thread {
    private Buffer buf;
    private String nom;
     public Conso(Buffer b, String nom) {
        this.buf = b;
        this.nom = nom;
    }
    public void run() {
        int valeur = 0;
        for (int i = 0; i < 10; i++) {
            valeur = buf.get();
            System.out.println(" Le Consommateur" + this.nom + " prend: " + buf.get());
        }
    }
}
