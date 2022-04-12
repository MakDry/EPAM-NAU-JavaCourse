package ua.advanced.practice3.task5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MedianQueue implements Iterable<Integer> {
    private Cell headCell;
    private int size = 0;

    private class Cell {
        private int value;
        private Cell nextCell;

        public Cell(int value) {
            this.value = value;
            nextCell = null;
        }

        public int getValue() {
            return value;
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

    // Returns middle value of the collection
    public int getMedian(){
        if (headCell == null){
            throw new NoSuchElementException("Collection is empty");
        }

        int index;
        Cell cellIterator = headCell;
        if (size % 2 == 0){
            index = size / 2;

            for (int i = 0; i < index; i++) {
                cellIterator = cellIterator.getNext();
            }
            return Math.min(cellIterator.getValue(), cellIterator.getNext().getValue());

        } else {
            index = (size - 1) / 2;

            for (int i = 0; i < index; i++) {
                cellIterator = cellIterator.getNext();
            }
            return cellIterator.getNext().getValue();
        }
    }

    // Push element to the queue
    public void offer(int value){
        Cell newCell = new Cell(value);

        if (headCell == null){
            headCell = newCell;
            size++;
            return;
        }
        Cell cellIterator = headCell;
        while (cellIterator.getNext() != null){
            cellIterator = cellIterator.getNext();
        }
        cellIterator.setNext(newCell);
        size++;
    }

    // Pull element out of the queue
    public int poll(){
        Cell pulledCell = headCell;
        headCell = headCell.getNext();
        size--;
        return pulledCell.getValue();
    }

    // Get element on the top of the queue (just get, no pulling out)
    public int peek(){
        Cell cellIterator = headCell;

        while (cellIterator.getNext() != null){
            cellIterator = cellIterator.getNext();
        }
        return cellIterator.getValue();
    }

    // Amount of current queue elements
    public int size(){
        return this.size;
    }

    private class CellIterator implements Iterator<Integer> {
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
    public Iterator<Integer> iterator() {
        return new CellIterator();
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
}