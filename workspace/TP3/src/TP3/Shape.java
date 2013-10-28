package TP3;

public class Shape {
    double x, y ;

    public Shape() {
        x = 0 ; y = 0 ;
    }

    public Shape(double x, double y) {
        this.x = x ; this.y = y ;
    }

    public String toString() {
        return "Position : (" + x + "," + y + ")" ;
    }
}
