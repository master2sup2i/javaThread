package TP3;

public class Main {
    public static void main(String[] args) {
        Circle c1,c2 ;
        c1 = new Circle(1,1,3) ;
        c2 = new Circle() ;
        System.out.println(c1.toString() + "\n" + c2.toString()) ;
        System.out.println("C1 est-il plus grand que C2? :" + c1.isBigger(c2));
    }
}
