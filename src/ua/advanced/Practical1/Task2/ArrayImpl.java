package ua.advanced.Practical1.Task2;

import java.util.Arrays; // З даної бібібліотеки було використано лише методи copyOf() та toString(), для виводу та створення динамічного масиву
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    private Object[] array;
    private IteratorImpl iterator = new IteratorImpl();

    public ArrayImpl(){
        array = new Object[4];
    }

    private class IteratorImpl implements Iterator<Object> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < array.length;
        }

        @Override
        public Object next() {
            if (counter >= array.length)
                throw new NoSuchElementException();
            counter++;
            return array[counter - 1];
        }

        @Override
        public void remove() {
            Object[] newArr;
            newArr = new Object[array.length - 1];
            for (int j = 0; j < (counter - 1); j++) {
                newArr[j] = array[j];
            }
            for (int j = (counter - 1); j < array.length - 1; j++) {
                newArr[j] = array[j + 1];
            }
            counter = 0;
            array = newArr;
        }

        @Override
        public String toString(){
            counter = 0;
            String output = "";
            while(iterator.hasNext()){
                output += iterator.next() + " ";
            }
            counter = 0;
            return output;
        }
    }

    @Override
    public void add(Object element) {
        while (true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null){
                    array[i] = element;
                    return;
                }
            }
            expandArray();
        }
    }

    @Override
    public void set(int index, Object element) {
        indexChecker(index);
        array[index] = element;
    }

    @Override
    public Object get(int index) {
        indexChecker(index);
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element))
                return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        indexChecker(index);
        Object[] newArr;
            newArr = new Object[array.length - 1];
            for (int j = 0; j < index; j++) {
                newArr[j] = array[j];
            }
            for (int j = index; j < array.length - 1; j++) {
                newArr[j] = array[j + 1];
            }
        array = newArr;
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return iterator;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private void indexChecker(int index) {
        try {
            if (index < 0 || index > array.length)
                throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void expandArray() {
        Object[] tempArray = Arrays.copyOf(array, array.length * 2);
        array = tempArray;
    }
}
