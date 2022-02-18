package ua.advanced.practice2.task1;

import ua.advanced.practice1.Task2.Container;

public interface List extends Container {
    void addFirst(Object element); // Inserts the specified element at the beginning.

    void addLast(Object element); // Appends the specified element to the end.

    void removeFirst(); // Removes the first element.

    void removeLast(); // Removes the last element.

    Object getFirst(); // Returns the first element.

    Object getLast(); // Returns the last element.

    Object search(Object element); // Returns the first occurrence of the specified element,
                                   // Returns null if no such element.
                                   // (use 'equals' method to check an occurrence)

    boolean remove(Object element); // Removes the first occurrence of the specified element.
                                    // Returns true if this list contained the specified element.
                                    // (use 'equals' method to check an occurrence)
}
