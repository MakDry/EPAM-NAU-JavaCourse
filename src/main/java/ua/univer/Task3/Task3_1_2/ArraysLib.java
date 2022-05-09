package ua.univer.Task3.Task3_1_2;

public class ArraysLib {

    public static SortOrder getSortOrder(int option) {
        SortOrder obj = SortOrder.NONSORTED;
        if (option == 1) {
            obj = SortOrder.ASC;
        } else if (option == 2) {
            obj = SortOrder.DESC;
        }
        return obj;
    }

    public static boolean IsSorted(int[] arr, SortOrder sortOrder) { // Method from task3_1
        for (int i = 0; i < arr.length - 1; i++) {
            if (sortOrder == SortOrder.ASC && arr[i] > arr[i + 1]) {
                return false;
            } else if (sortOrder == SortOrder.DESC && arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] Transform(int[] arr, boolean opt) { // Method from task3_2
        if (opt == true) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + i;
            }
        }
        return arr;
    }

    public static void getArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
