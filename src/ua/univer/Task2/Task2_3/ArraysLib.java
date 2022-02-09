package ua.univer.Task2.Task2_3;

public class ArraysLib {

    public static void processMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int cell = 0; cell < matrix.length; cell++) {
                if (cell > row) {
                    matrix[row][cell] = 1;
                } else if (cell < row) {
                    matrix[row][cell] = 0;
                }
            }
        }
    }

    public static void getMatrix(int[][] arr){
        for (var row : arr) {
            for (var cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
