package ua.advanced.practice2.task3;

import ua.advanced.practice1.Task2.Container;

public interface Stack extends Container {
    void push(Object element); // Pushes the specified element onto the top.

    Object pop(); // Removes and returns the top element.

    Object top(); // Returns the top element.
}
