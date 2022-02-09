package ua.univer.Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = 4;
        Rectangle[] rectangle_array = new Rectangle[n];

        System.out.println(">Input side A for ur first rectangle: ");
        int sideA1 = input.nextInt();
        System.out.println(">Input side B for ur first rectangle: ");
        int sideB1 = input.nextInt();
        Rectangle rec1 = new Rectangle(sideA1, sideB1);
        System.out.println(">Input side A for ur second rectangle: ");
        int sideA2 = input.nextInt();
        Rectangle rec2 = new Rectangle(sideA2);
        Rectangle rec3 = new Rectangle();

        rectangle_array[0] = rec1;
        rectangle_array[1] = rec2;
        rectangle_array[2] = rec3;

        ArrayRectangles rec_array = new ArrayRectangles(rectangle_array);

        System.out.println(">Input side A for ur new rectangle: ");
        int sideAnew = input.nextInt();
        System.out.println(">Input side B for ur new rectangle: ");
        int sideBnew = input.nextInt();
        Rectangle rec4 = new Rectangle(sideAnew, sideBnew);
        System.out.println("<Your rectangle was successfully added>");
        System.out.println(">Is there some free space in the array? : " + rec_array.addRectangle(rec4));

        System.out.println(">The index of the rectangle with the largest area: " + rec_array.numberMaxArea());
        System.out.println(">The index of the rectangle with the smallest parameter: " + rec_array.numberMinPerimeter());
        System.out.println(">The number of squares in the array: " + rec_array.numberSquare());

    }
}
