package ua.univer.Task2.Task2_1;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 1, 64, 4, 11, 22};
        ArraysLib.getArray(arr);                             //       2, 1, 64, 4, 11, 22,
        System.out.println("\n");                            //Output:
        ArraysLib.getArray(ArraysLib.changePosition(arr));   //       22, 1, 4, 64, 11, 2,
    }
}
