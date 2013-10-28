package TP3;

public class Circle extends Shape {
    final static double PI = 3.141592564 ;
    private double surface;
    private double radius ;
    

    public Circle() {
        radius = 0 ;
    }

    public Circle(double x, double y, double r) {
        super(x,y) ;
        radius = r ;
    }

    public String toString() {
        return super.toString() + " Rayon : " + radius ;
    }

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Boolean isBigger(Circle c){
		Boolean bool;
		if (this.surface>c.surface){
			surface = radius*radius*PI;
			return true;
		}
		else{
			return false;
		}
	}
    
   
    
}
