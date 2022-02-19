package ua.advanced.practice1.task2;

import java.util.Iterator;

public class Main {
    private static Object A;
    private static Object B;
    private static Object C;
    private static Object D;

    static {
        A = "A";
        B = "B";
        C = "C";
        D = "D";
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();
        array.add(A);
        array.add(B);
        array.add(C);
        array.add(D);
        System.out.println(">Array after adding new objects: " + array);

        array.remove(3);
        System.out.println(">Array after removing the object with index \'3\': " + array);

        System.out.println(">Getting index of \'B\' object: " + array.indexOf(B));

        System.out.println(">Array size: " + array.size());

        System.out.println(">Getting object by index \'2\': " + array.get(2));

        array.set(0, D);
        System.out.println(">Array after replacing the object with index \'0\' by object \'D\': " + array);

        System.out.println(">Array output by iterator: " + printWithIterator(array));

        array.iterator().remove();
        System.out.println(">Array after removing (index 2) object by iterator: " + printWithIterator(array));

        array.clear();
        System.out.println(">Array after clearing: " + array);
    }

    private static String printWithIterator(ArrayImpl array) {
        Iterator iter = array.iterator();
        String elements = "";
        while (iter.hasNext()){
            elements += iter.next() + " ";
        }
        return elements;
    }
}