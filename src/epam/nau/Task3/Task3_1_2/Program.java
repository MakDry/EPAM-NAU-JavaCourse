package epam.nau.Task3.Task3_1_2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println(">Input 6 numbers for ur new array: ");
        int[] arr = new int[5];
        int i = 0;
        while (i < 5) {
            System.out.println("\n>Print number with index " + i + ": ");
            int num = input.nextInt();
            arr[i] = num;
            i++;
        }
        System.out.println("\n>How is ur array sorted? \n1.Ascending \n2.Descending");
        int option = new Scanner(System.in).nextInt();
        SortOrder sortOrder = ArraysLib.getSortOrder(option);
        System.out.println(">Is this array sorted correctly? \n" + ArraysLib.IsSorted(arr, sortOrder)); // Calling the method from task3_1
        ArraysLib.getArray(ArraysLib.Transform(arr, ArraysLib.IsSorted(arr, sortOrder))); // Calling the method from task3_2
    }
}
