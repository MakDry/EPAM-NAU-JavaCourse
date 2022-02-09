package ua.univer.Task5;

import java.util.Arrays;

public class ArrayRectangles {

    private Rectangle[] rectangle_array;

    public ArrayRectangles(int n) {
        rectangle_array = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle[] arr) {
        rectangle_array = arr;
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle_array.length; i++) {
            if (rectangle_array[i] == null) {
                    rectangle_array[i] = rectangle;
                    return true;
            }
        }
        return false;
    }

    public int numberMaxArea() {
        double maxArea = 0;
        int index = 0;
        for (var item : rectangle_array) {
            if (item != null) {
                if (item.area() > maxArea) {
                    maxArea = item.area();
                    index = Arrays.asList(rectangle_array).indexOf(item);
                }
            }

        }
        return index;
    }

    public int numberMinPerimeter() {
        double minPer = 1000;
        int index = 0;
        for (var item : rectangle_array) {
            if (item != null) {
                if (item.perimeter() < minPer) {
                    minPer = item.perimeter();
                    index = Arrays.asList(rectangle_array).indexOf(item);
                }
            }
        }
        return index;
    }

    public int numberSquare() {
        int counter = 0;
        for (var item : rectangle_array) {
            if (item != null) {
                if (item.isSquare() == true) {
                    counter++;
                }
            }
        }
        return counter;
    }
}