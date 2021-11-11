package epam.nau.Task2.Task2_1;

public class ArraysLib {

    public static int[] changePosition(int[] arr) {
        int arr1[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int v = arr.length - i - 1;
                arr1[v] = arr[i];
                v--;
            } else {
                arr1[i] = arr[i];
            }
        }
        return arr1;
    }

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
