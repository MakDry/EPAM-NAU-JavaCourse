package ua.advanced.practice3.task4;

import java.util.Collection;
import java.util.Iterator;

public class AbsoluteValueIntegerSet implements Iterable<Integer>{
    private final Cell headCell = new Cell(0);
    private int size = 1;

    private class Cell {
        private int value;
        private Cell nextCell;

        public Cell(int value){
            this.value = value;
            nextCell = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Cell getNext() {
            return nextCell;
        }

        public void setNext(Cell nextCell) {
            this.nextCell = nextCell;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    // Adding element
    public void add(int value){
        Cell newCell = new Cell(value);

        Cell cellIterator = headCell;
        while (cellIterator.getNext() != null && value > cellIterator.getNext().getValue()){
            cellIterator = cellIterator.getNext();
        }

        newCell.setNext(cellIterator.getNext());
        cellIterator.setNext(newCell);
        size++;
    }

    // Removing element
    public boolean remove(int value){
        Cell cellIterator = headCell;

        while (cellIterator.getNext() != null){
            if (cellIterator.getNext().getValue() == value){
                Cell nextCell = cellIterator.getNext().getNext();
                cellIterator.setNext(nextCell);
                size--;
                return true;
            }
            cellIterator = cellIterator.getNext();
        }
        return false;
    }

    // Searching element
    public boolean search(int value){

        Cell cellIterator = headCell;
        while (cellIterator.getNext() != null){
            if (cellIterator.getValue() == value){
                return true;
            }
            cellIterator = cellIterator.getNext();
        }
        return false;
    }

    // Adding of a collection
    public void addCollection(Collection<Integer> collection){
        for (int value : collection){
            if (value != 0) {
                add(value);
            }
        }
    }

    private class CellIterator implements Iterator<Integer>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public Integer next() {
            Cell cellIterator = headCell;
            for (int i = 0; i < counter; i++) {
                cellIterator = cellIterator.getNext();
            }
            counter++;
            return cellIterator.getValue();
        }
    }

    @Override
    public String toString() {
        String result = "{ ";

        Cell cellIterator = headCell;

        for (int i = 0; i < size; i++) {
            result = result.concat(cellIterator.getValue() + ", ");
            cellIterator = cellIterator.getNext();
        }
        result = result.concat(" }");
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CellIterator();
    }
}