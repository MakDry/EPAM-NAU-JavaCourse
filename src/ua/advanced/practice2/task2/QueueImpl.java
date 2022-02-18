package ua.advanced.practice2.task2;

import ua.advanced.practice2.entity.City;

import java.util.Arrays;
import java.util.Iterator;

public class QueueImpl implements Queue {
    private City[] queue;

    public QueueImpl() {
        queue = new City[4];
    }

    private class IteratorImpl implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public Object next() {
            counter++;
            return queue[counter - 1];
        }

        @Override
        public void remove() {
            City[] temp;
            temp = new City[queue.length - 1];
            for (int j = 0; j < counter; j++) {
                temp[j] = queue[j];
            }
            for (int j = counter; j < queue.length - 1; j++) {
                temp[j] = queue[j + 1];
            }
            counter = 0;
            queue = temp;
        }
    }

    @Override
    public void enqueue(City element) {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                queue[i] = element;
                return;
            }
        }
    }

    @Override
    public City dequeue() {
        City deletedHead = new City();
        if (queue[0] != null) {
            deletedHead = queue[0];
            City[] temp = new City[queue.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = queue[i + 1];
            }
            queue = temp;
        }
        return deletedHead;
    }

    @Override
    public City top() {
        return queue[0];
    }

    @Override
    public void clear() {
        queue = new City[queue.length];
    }

    @Override
    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null)
                sizeCounter++;
        }
        return sizeCounter;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        String out = "[";
        for (City city : queue) {
            out = out.concat(" " + city.getName());
        }
        out = out.concat(" ]");
        return out;
    }
}
