package ua.advanced.practice2.task2;

import ua.advanced.practice1.Task2.Container;
import ua.advanced.practice2.entity.City;

public interface Queue extends Container {
    void enqueue(City element); // Appends the specified element to the end.

    City dequeue(); // Removes the head.

    City top(); // Returns the head.
}
