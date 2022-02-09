package ua.univer.Task2.Task2_2;

public class ArraysLib {

    public static int distanceCounter(int[] arr) {
        int result = 0;
        int max_el = arr[0];
        for (int el : arr) {
            max_el = Math.max(max_el, el);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max_el) {
                int dist = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    dist++;
                    if (arr[j] == max_el) {
                        result = dist;
                    }
                }
            }
        }
        return result;
    }
}
