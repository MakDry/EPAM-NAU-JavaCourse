package ua.univer.Task1.Task1_1;

public class Program {

    public static void main(String[] args) {
        System.out.println("n = " + 5 + "\tresult = " + processing(5)); // Output: n = 5  result = 25
        System.out.println("n = " + -6 + "\tresult = " + processing(-6)); // Output: n = -6  result = 6
        System.out.println("n = " + 0 + "\tresult = " + processing(0)); // Output: n = 0  result = 0
    }

    public static int processing(int n) {
        int result = 0;

        if (n > 0) {
            result = n * n;
        } else if (n < 0) {
            result = Math.abs(n);
        }
        return result;
    }
}
