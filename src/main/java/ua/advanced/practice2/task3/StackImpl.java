package ua.advanced.practice2.task3;

import ua.advanced.practice2.entity.City;

import java.util.Iterator;

public class StackImpl implements Stack {
    private City[] stack;

    public StackImpl() {
        stack = new City[4];
    }

    private class IteratorImpl implements Iterator {
        private int counter = size() - 1;

        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public Object next() {
            counter--;
            return stack[counter + 1];
        }

        @Override
        public void remove() {
            City[] temp = new City[stack.length - 1];
            stack[counter] = null;
            for (int i = 0; i < size(); i++) {
                temp[i] = stack[i];
            }
            counter = size() - 1;
            stack = temp;
        }
    }

    @Override
    public void clear() {
        stack = new City[4];
    }

    @Override
    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] != null)
                sizeCounter++;
        }
        return sizeCounter;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void push(City element) {
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == null) {
                stack[i] = element;
                return;
            }
        }
    }

    @Override
    public City pop() {
        City topElement = stack[size() - 1];
        City[] temp = new City[stack.length - 1];
        for (int i = 0; i < (size() - 1); i++) {
            temp[i] = stack[i];
        }
        stack = temp;
        return topElement;
    }

    @Override
    public City top() {
        return stack[size() - 1];
    }

    @Override
    public String toString() {
        String out = "[";
        for (City city : stack){
            if (city != null){
                out = out.concat(" " + city.getName());
            }
        }
        out = out.concat(" ]");
        return out;
    }
}