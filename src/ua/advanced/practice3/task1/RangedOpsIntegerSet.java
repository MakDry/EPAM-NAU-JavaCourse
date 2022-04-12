package ua.advanced.practice3.task1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;

public class RangedOpsIntegerSet implements Iterable<Integer> {
    private Integer[] integerArray;


    public RangedOpsIntegerSet() {
        integerArray = new Integer[10];
    }

    private class LocalIterator implements Iterator<Integer>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if (counter == integerArray.length) {
                return false;
            } else if (integerArray[counter] != null){
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
            counter++;
            return integerArray[counter - 1];
        }

        @Override
        public void remove() {
            integerArray[counter] = null;
            reduceArray();
            counter = 0;
        }
    }

    //Adds a range of values into the set (first argument - inclusive, last argument - exclusive).
    // Return true if any of range values were actually added.
    public boolean add(Integer fromInclusive, Integer toExclusive) throws InputMismatchException {
        boolean addingResult = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            add(i);

            if (!addingResult && reiterationChecker(i))
                addingResult = true;
        }
        return addingResult;
    }

    //Removes a range of values from the list (first argument - inclusive, last argument - exclusive).
    // Return true if any of range values were actually removed.
    public boolean remove(int fromInclusive, int toExclusive) {
        boolean removingResult = false;
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] != null && integerArray[i] >= fromInclusive && integerArray[i] < toExclusive){
                integerArray[i] = null;
                if (!removingResult)
                    removingResult = true;
            }
        }
        reduceArray();
        return removingResult;
    }

    //Adds a single value into the set
    public void add(Integer singleValue) {
        if (!reiterationChecker(singleValue))
            return;

        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[integerArray.length - 1] != null)
                growArray();

            if (integerArray[i] == null) {
                integerArray[i] = singleValue;
                return;
            }
        }
    }

    //Removes a single value from the set
    public void remove(int singleValue) {
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] == singleValue) {
                integerArray[i] = null;
                reduceArray();
                return;
            }
        }
    }

    //Returns the number of current queue elements
    public int size() {
        int size = 0;
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] != null)
                size++;
        }
        return size;
    }

    private boolean reiterationChecker(int value) {
        for (int i = 0; i < size(); i++) {
            if (integerArray[i] == value)
                return false;
        }
        return true;
    }

    private void growArray() {
        Integer[] temp = Arrays.copyOf(integerArray, integerArray.length * 2);
        integerArray = temp;
    }

    private void reduceArray(){
        Integer[] temp = new Integer[size()];
        int position = 0;

        for (Integer digit : integerArray){
            if (digit != null){
                temp[position] = digit;
                position++;
            }
        }
        integerArray = temp;
    }

    //Iterates over elements of the set in natural order.
    @Override
    public Iterator iterator() {
        return new LocalIterator();
    }

    @Override
    public String toString() {
        return "RangedOpsIntegerSet{" +
                "integerArray=" + Arrays.toString(integerArray) +
                '}';
    }
}
