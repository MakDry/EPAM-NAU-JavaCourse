package ua.advanced.practice2.task1;

import java.util.Iterator;

public class ListImpl implements List {
    private Node[] list;

    public ListImpl() {
        list = new Node[3];
    }

    private static class Node {
        private Object object;
        private Object nextObject;

        public Node(Object object, Object nextObject) {
            this.object = object;
            this.nextObject = nextObject;
        }

        public Object getObject() {
            return object;
        }

        public Object getNextObject() {
            return nextObject;
        }

        public void setNextObject(Object nextObject) { // It can be useless
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
    public void addFirst(Object element) {
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
    public void addLast(Object element) {
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
    public Object getFirst() {
        return list[0].getObject();
    }

    @Override
    public Object getLast() {
        return list[size() - 1].getObject();
    }

    @Override
    public Object search(Object element) {
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
    public boolean remove(Object element) {
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
                out = out.concat(" " + node.getObject().toString());
        }
        out = out.concat(" ]");
        return out;
    }

    private Node nodeCreator(Object element, int index) {
        return index == 0 ? new Node(element, list[1]) : new Node(element, null);
    }
}
