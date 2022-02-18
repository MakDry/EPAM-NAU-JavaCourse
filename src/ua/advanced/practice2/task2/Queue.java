package ua.advanced.practice2.task2;

import ua.advanced.practice1.Task2.Container;

public interface Queue extends Container {
    void enqueue(Object element); // Appends the specified element to the end.

    Object dequeue(); // Removes the head.

    Object top(); // Returns the head.
}
