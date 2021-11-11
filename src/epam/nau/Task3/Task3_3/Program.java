package epam.nau.Task3.Task3_3;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println(">Print a1: ");
        int a1 = new Scanner(System.in).nextInt();
        System.out.println(">Print n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println(">Print t: ");
        int t = new Scanner(System.in).nextInt();
        System.out.println(">Result: " + Arithmetic.MultArithmeticElements(a1, n, t));
    }
}
