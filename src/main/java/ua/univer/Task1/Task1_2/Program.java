package ua.univer.Task1.Task1_2;

public class Program {
    public static void main(String[] args) {
        System.out.println("n = " + 257 + "\tresult = " + processing(257)); // Output: n = 257  result = 752
        System.out.println("n = " + 189 + "\tresult = " + processing(189)); // Output: n = 189  result = 981
        System.out.println("n = " + 108 + "\tresult = " + processing(108)); // Output: n = 108  result = 801
    }

    public static int processing(int n) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            result += n % 10;
            result *= 10;
            n /= 10;
        }
        result /= 10;
        return result;
    }
}
