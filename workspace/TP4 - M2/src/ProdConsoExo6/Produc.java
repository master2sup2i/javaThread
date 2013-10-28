package ProdConsoExo6;

public class Produc extends Thread {
    private Buffer buf;
    
    public Produc(Buffer b) {
        this.buf = b; 
    }
    
    public void run() {
    	for (int i = 0; i < 10; i++) {
    	       buf.put(i);
    	}
    }
}

