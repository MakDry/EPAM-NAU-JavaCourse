package ua.advanced.practice3.task3;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairStringList implements Iterable<String> {
    private Cell headCell;
    private int size = 0;

    private class Cell {
        private String value;
        private Cell nextCell;

        public Cell(String value) {
            this.value = value;
            nextCell = null;
        }

        public Cell(String value, Cell nextCell) {
            this.value = value;
            this.nextCell = nextCell;
        }

        public String getValue() {
            return value;
        }

        public Cell getNext() {
            return nextCell;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setNext(Cell nextCell) {
            this.nextCell = nextCell;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    // Adding
    public void add(String value) {
        Cell pairCell = new Cell(value);
        Cell newCell = new Cell(value, pairCell);

        if (headCell == null) {
            headCell = newCell;
            size += 2;
            return;
        }

        Cell cellIterator = headCell;
        while (cellIterator.getNext() != null) {
            cellIterator = cellIterator.getNext();
        }
        cellIterator.setNext(newCell);
        size += 2;
    }

    public boolean add(String value, int index) {
        if (indexChecker(index)) {
            return false;
        } else if (index % 2 == 0) {
            index++;
        }

        Cell pairCell = new Cell(value);
        Cell newCell = new Cell(value, pairCell);

        Cell cellIterator = cellIterator(index);
        pairCell.setNext(cellIterator.getNext());
        cellIterator.setNext(newCell);
        size += 2;

        return true;
    }

    // Removing of object
    public boolean remove(String value) {
        Cell cellIterator = headCell;

        while (cellIterator.getNext() != null) {
            if (cellIterator.getNext().getValue().equals(value)) {
                if (cellIterator == headCell){
                    headCell = cellIterator.getNext().getNext();
                    size -= 2;
                    return true;
                }

                Cell nextCell = cellIterator.getNext().getNext().getNext();
                cellIterator.setNext(nextCell);
                size -= 2;
                return true;
            }
            cellIterator = cellIterator.getNext();
        }
        return false;
    }

    // Removing by index
    public boolean remove(int index) {
        if (indexChecker(index)) {
            return false;
        }
        return remove(cellIterator(index).getValue());
    }

    // Getting by index
    public Cell get(int index) {
        if (indexChecker(index)) {
            return new Cell("Value with such index wasn't found");
        } else if (headCell == null){
            throw new NoSuchElementException("There are no values");
        }
        return cellIterator(index);
    }

    // Setting by index
    public boolean set(String value, int index) {
        if (indexChecker(index)) {
            return false;
        } else if (index % 2 != 0) {
            index--;
        }

        Cell cellIterator = cellIterator(index);
        cellIterator.setValue(value);
        cellIterator.getNext().setValue(value);
        return true;
    }

    // Adding of a collection
    public void addCollection(Collection<String> collection) {
        for (String value : collection) {
            if (value != null) {
                add(value);
            }
        }
    }

    // Adding of a collection by index
    public void addCollection(Collection<String> collection, int index) {
        if (indexChecker(index)) {
            return;
        }

        for (String value : collection) {
            if (value != null){
                add(value, index);
            }
        }
    }

    public int getSize() {
        return size;
    }

    private Cell cellIterator(int index){
        Cell iterator = headCell;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    private boolean indexChecker(int index){
        return index >= size;
    }

    private class CellIterator implements Iterator<String>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return get(counter).getNext() != null;
        }

        @Override
        public String next() {
            return get(++counter).getValue();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new CellIterator();
    }

    @Override
    public String toString() {
        String result = "{ ";

        Cell cellIterator = headCell;

        for (int i = 0; i < size; i++) {
            result = result.concat(cellIterator.getValue()).concat(", ");
            cellIterator = cellIterator.getNext();
        }
        result = result.concat(" }");
        return result;
    }
}