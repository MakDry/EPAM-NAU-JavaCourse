package epam.nau.Task3.Task3_3;

public class Arithmetic {

    public static int MultArithmeticElements(int a1, int n, int t) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a1;
            int temp = a1 + t;
            a1 = temp;
        }
        return result;
    }
}
