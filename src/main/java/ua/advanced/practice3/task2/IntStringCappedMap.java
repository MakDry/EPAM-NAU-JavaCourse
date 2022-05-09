package ua.advanced.practice3.task2;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

public class IntStringCappedMap implements Iterable{
    private final int stringsMaxCapacity;
    private int removingQueue = 0;
    private Cell[] cells;

    public IntStringCappedMap(int stringsMaxCapacity) {
        this.stringsMaxCapacity = stringsMaxCapacity;
        cells = new Cell[10];
    }

    private  class Cell{
        private final int key;
        private final String value;

        public Cell(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int capacity() {
            return value.length();
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    private class LocalIterator implements Iterator<Cell> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if (counter == cells.length) {
                return false;
            } else if (cells[counter] != null){
                return true;
            }
            return false;
        }

        @Override
        public Cell next() {
            counter++;
            return cells[counter - 1];
        }
    }

    @Override
    public Iterator iterator() {
        return new LocalIterator();
    }

    // Returns an AbstractSet.
    public AbstractSet entrySet() {
        return new AbstractSet() {

            @Override
            public Iterator<Cell> iterator() {
                return new LocalIterator();
            }

            @Override
            public int size() {
                int sizeCounter = 0;

                for (int i = 0; i < cells.length; i++) {
                    if (cells[i] != null)
                        sizeCounter++;
                }

                return sizeCounter;
            }
        };
    }

    // Return a value by its key.
    public String get(int key) {
        for (Cell cell : cells) {
            if (key == cell.getKey())
                return cell.getValue();
        }
        return "<There is no value with such key>";
    }

    // Set a value by a given key.
    public void put(int key, String value) {
        capacityChecker(value);

        if (cells.length == size())
            growArray();

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == null){
                cells[i] = new Cell(key, value);
                return;
            }
        }
    }

    // Returns number of map entries.
    public int size() {
        int sizeCounter = 0;

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != null)
                sizeCounter++;
        }

        return sizeCounter;
    }

    private void capacityChecker(String value) {
        try {
            if (stringsMaxCapacity < (capacityCalculator() + value.length()))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            while (stringsMaxCapacity < (capacityCalculator() + value.length())) {
                cells[removingQueue] = null;
                removingQueue++;
            }
        }
    }

    private int capacityCalculator() {
        int capacity = 0;

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != null)
                capacity += cells[i].capacity();
        }
        return capacity;
    }

    private void growArray() {
        Cell[] temp = Arrays.copyOf(cells, cells.length * 2);
        cells = temp;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (Cell cell : cells) {
            if (cell != null){
                result = result.concat(cell.getKey() + "=" + cell.getValue() + ", ");
            }
        }
        return result.concat("}");
    }
}
