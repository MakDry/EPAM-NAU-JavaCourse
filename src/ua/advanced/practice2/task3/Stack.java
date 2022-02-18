package ua.advanced.practice2.task3;

import ua.advanced.practice1.Task2.Container;
import ua.advanced.practice2.entity.City;

public interface Stack extends Container {
    void push(City element); // Pushes the specified element onto the top.

    City pop(); // Removes and returns the top element.

    City top(); // Returns the top element.
}
