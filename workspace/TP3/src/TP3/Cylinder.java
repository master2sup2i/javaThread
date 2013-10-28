package TP3;

public class Cylinder extends Circle{
	private double hauteur;


    public Cylinder() {
        hauteur = 0 ;
    }
    
	public Cylinder(double x, double y, double r,double h) {
    	super(x,y,r) ;
    	hauteur = h ;
	}

}