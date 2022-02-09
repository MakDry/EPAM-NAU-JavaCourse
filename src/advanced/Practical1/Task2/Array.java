package advanced.Practical1.Task2;

public interface Array extends Container{
    void add(Object element); // Add the specified element to the end.

    void set(int index, Object element); // Sets the element at the specified position.

    Object get(int index); // Returns the element at the specified position.

    int indexOf(Object element); // Returns the index of the first occurrence of the specified element,
                                 // or -1 if this array does not contain the element
                                 // (use 'equals' method to check an occurrence)
    void remove(int index); // Removes the element at the specified position.
}
