package ProdConsoExo6;

public class Buffer {
    private Integer valeur;
    private boolean consommer = false;
    
    public int get() {
        while (consommer) {}
            consommer = true;
            synchronized (valeur)
            {
            	return valeur;
            }   
    }
    
   public void put(int i) {
    	while (!consommer) {}
    	synchronized (valeur)
    	{
    		valeur = i;
    	}
        consommer = false;
    }  
}