package ua.advanced.practice2.task2;

import java.util.Arrays;
import java.util.Iterator;

public class QueueImpl implements Queue {
    private Object[] queue;

    public QueueImpl() {
        queue = new Object[4];
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
            Object[] temp;
            temp = new Object[queue.length - 1];
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
    public void enqueue(Object element) {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == null) {
                queue[i] = element;
                return;
            }
        }
    }

    @Override
    public Object dequeue() {
        Object deletedHead = new Object();
        if (queue[0] != null) {
            deletedHead = queue[0];
            Object[] temp = new Object[queue.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = queue[i + 1];
            }
            queue = temp;
        }
        return deletedHead;
    }

    @Override
    public Object top() {
        return queue[0];
    }

    @Override
    public void clear() {
        queue = new Object[queue.length];
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
        return Arrays.toString(queue);
    }
}
