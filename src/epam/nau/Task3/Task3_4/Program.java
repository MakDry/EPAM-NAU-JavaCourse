package epam.nau.Task3.Task3_4;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        System.out.println(">Print a1: ");
        int a1 = new Scanner(System.in).nextInt();
        System.out.println(">Print t: ");
        double t = new Scanner(System.in).nextDouble();
        System.out.println(">Print n: ");
        int alim = new Scanner(System.in).nextInt();
        System.out.println(">Result: " + Arithmetic_4.SumGeometricElements(a1, t, alim));
    }
}
