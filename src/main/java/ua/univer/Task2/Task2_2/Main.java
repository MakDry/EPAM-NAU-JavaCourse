package ua.univer.Task2.Task2_2;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 20, 2, 2, 20};
        int[] arr2 = {10, 10, 1, 2, 3};
        int[] arr3 = {12, 12, 300, 12, 300};
        int[] arr4 = {100, 10, 9, 12, 11};

        System.out.println(">Distance in arr1 = " + ArraysLib.distanceCounter(arr1)); // >Distance in arr1 = 3
        System.out.println(">Distance in arr2 = " + ArraysLib.distanceCounter(arr2)); // >Distance in arr2 = 1
        System.out.println(">Distance in arr3 = " + ArraysLib.distanceCounter(arr3)); // >Distance in arr3 = 2
        System.out.println(">Distance in arr4 = " + ArraysLib.distanceCounter(arr4)); // >Distance in arr3 = 0
    }
}