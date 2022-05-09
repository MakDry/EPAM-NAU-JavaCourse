package ua.univer.Task1.Task1_4;

public class Program {
    public static void main(String[] args) {
        System.out.println("n = " + 16 + "\tresult = " + processing(16));   // Output: n = 16  result = 1
        System.out.println("n = " + 281 + "\tresult = " + processing(281)); // Output: n = 281 result = 4
        System.out.println("n = " + 47 + "\tresult = " + processing(47));   // Output: n = 47  result = 5
    }

    public static int processing(int n) {
        int value;
        int result = 0;

        while (n != 0) {
            value = n % 2;

            if (value == 1) {
                result++;
            }
            n /= 2;
        }
        return result;
    }
}