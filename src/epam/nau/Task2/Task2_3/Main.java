package epam.nau.Task2.Task2_3;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 7, 2, 1},
                {7, 20, 6, 10},
                {12, 24, 30, 11},
                {74, 2, 2, 40}
        };
        ArraysLib.getMatrix(matrix);
        ArraysLib.processMatrix(matrix);
        System.out.println();
        ArraysLib.getMatrix(matrix);

//        10	7	2	1
//        7	    20	6	10
//        12	24	30	11
//        74	2	2	40
// Output:
//        10	1	1	1
//        0	    20	1	1
//        0	    0	30	1
//        0	    0	0	40
    }
}
