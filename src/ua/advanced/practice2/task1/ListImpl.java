package ua.advanced.practice2.task1;

import ua.advanced.practice2.entity.City;

import java.util.Iterator;

public class ListImpl implements List {
    private Node[] list;

    public ListImpl() {
        list = new Node[3];
    }

    private static class Node {
        private City object;
        private Node nextObject;

        public Node(City object, Node nextObject) {
            this.object = object;
            this.nextObject = nextObject;
        }

        public City getObject() {
            return object;
        }

        public Node getNextObject() {
            return nextObject;
        }

        public void setNextObject(Node nextObject) { // It can be useless
            this.nextObject = nextObject;
        }
    }

    private class IteratorImpl implements Iterator {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public Object next() {
            counter++;
            return list[counter - 1].getObject();
        }

        @Override
        public void remove() {
            Node[] temp = new Node[list.length];
            list[counter - 1].setNextObject(list[counter + 1]);
            list[counter] = null;
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null) {
                    temp[i] = list[i];
                }
            }
            list = temp;
            counter = 0;
        }
    }

    @Override
    public void clear() {
        list = new Node[list.length];
    }

    @Override
    public int size() {
        int sizeCounter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null)
                sizeCounter++;
        }
        return sizeCounter;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void addFirst(City element) {
        if (list[0] != null) {
            Node[] temp = new Node[list.length + 1];
            for (int i = 0; i < list.length; i++) {
                temp[i + 1] = list[i];
            }
            list = temp;
        }
        list[0] = nodeCreator(element, 0);
    }

    @Override
    public void addLast(City element) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = nodeCreator(element, i);
                list[i - 1].setNextObject(list[i]);
                return;
            }
        }
    }

    @Override
    public void removeFirst() {
        if (list[0] != null) {
            Node[] temp = new Node[list.length];
            for (int i = 0; i < list.length - 1; i++) {
                temp[i] = list[i + 1];
            }
            list = temp;
        }
    }

    @Override
    public void removeLast() {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getNextObject() == null) {
                list[i] = null;
                list[i - 1].setNextObject(null);
                return;
            }
        }
    }

    @Override
    public City getFirst() {
        return list[0].getObject();
    }

    @Override
    public City getLast() {
        return list[size() - 1].getObject();
    }

    @Override
    public City search(City element) {
        for (Node node : list) {
            if (node != null) {
                if (node.getObject().equals(element)) {
                    return node.getObject();
                }
            }
        }
        return null;
    }

    @Override
    public boolean remove(City element) {
        Node[] temp = new Node[list.length];
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getObject().equals(element)) {
                if (i + 1 < list.length) {
                    list[i - 1].setNextObject(list[i + 1]);
                } else {
                    list[i - 1].setNextObject(null);
                }
                list[i] = null;
                for (int j = 0; j < list.length; j++) {
                    if (list[j] != null) {
                        temp[j] = list[j];
                    }
                }
                list = temp;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String out = "[";
        for (Node node : list) {
            if (node != null)
                out = out.concat(" " + node.getObject().getName());
        }
        out = out.concat(" ]");
        return out;
    }

    private Node nodeCreator(City element, int index) {
        return index == 0 ? new Node(element, list[1]) : new Node(element, null);
    }
}