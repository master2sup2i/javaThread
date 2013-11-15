package TP5;

import java.util.Scanner;

public class MainTP5{
@SuppressWarnings("resource")
public static void main(String[] argv) {
    System.out.println("Entrez un nombre ");
    Integer nb = new Scanner(System.in).nextInt();
    try {
        System.out.println("fact(" + nb + ") : " + TP5.calc(nb));
    } catch (Exception ex) {
        System.out.println("Le nombre est trop grand !");
    }
}
}
