package ua.advanced.practice1.Task2;

import java.util.Iterator;

public interface Container extends Iterable<Object>{
    void clear(); // Removes all the elements.

    int size(); // Returns the number of elements.

    String toString(); // Returns a string representation of this container.

    Iterator<Object> iterator(); // Returns an iterator over elements. Iterator must implement the remove method.
}
