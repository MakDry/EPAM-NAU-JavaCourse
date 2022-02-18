package ua.advanced.practice2.task1;

import ua.advanced.practice1.Task2.Container;
import ua.advanced.practice2.entity.City;

public interface List extends Container {
    void addFirst(City element); // Inserts the specified element at the beginning.

    void addLast(City element); // Appends the specified element to the end.

    void removeFirst(); // Removes the first element.

    void removeLast(); // Removes the last element.

    City getFirst(); // Returns the first element.

    City getLast(); // Returns the last element.

    City search(City element); // Returns the first occurrence of the specified element,
                                   // Returns null if no such element.
                                   // (use 'equals' method to check an occurrence)

    boolean remove(City element); // Removes the first occurrence of the specified element.
                                    // Returns true if this list contained the specified element.
                                    // (use 'equals' method to check an occurrence)
}
