package ua.univer.Task1.Task1_3;

public class Program {
    public static void main(String[] args) {
        System.out.println("n = " + 4321 + "\tresult = " + processing(4321)); // Output: n = 4321  result = 4
        System.out.println("n = " + 248 + "\t\tresult = " + processing(248)); // Output: n = 248   result = 0
        System.out.println("n = " + 1333 + "\tresult = " + processing(1333)); // Output: n = 1333  result = 10
    }

    public static int processing(int n) {
        int result = 0;

        while (n != 0) {
            int value = n % 10;

            if ((n % 2) == 1) {
                result += value;
            } else {
                result += 0;
            }
            n /= 10;
        }
        return result;
    }
}
