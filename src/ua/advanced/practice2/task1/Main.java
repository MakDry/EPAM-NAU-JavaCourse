package ua.advanced.practice2.task1;

import java.util.Iterator;

public class Main {
    private static Object A;
    private static Object B;
    private static Object C;
    private static Object D;
    private static Object H;

    static{
        A = "A";
        B = "B";
        C = "C";
        D = "D";
        H = "H";
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst(B);
        list.addFirst(A);
        list.addLast(C);
        list.addLast(D);
        System.out.println(">List after adding new objects: " + list);
        System.out.println(">List size: " + list.size());

        System.out.println(">Try to delete object \'H\': " + list.remove(H));
        System.out.println(">List after removing the object \'H\': " + list);
        System.out.println(">Try to delete object \'D\': " + list.remove(D));
        System.out.println(">List after removing the object \'D\': " + list);

        System.out.println(">Using method getFirst(): " + list.getFirst());
        System.out.println(">Using method getLast(): " + list.getLast());

        System.out.println(">Searching for object \'H\': " + list.search(H));
        System.out.println(">Searching for object \'A\': " + list.search(A));

        System.out.println(">List output by iterator: " + printWithIterator(list));

        list.removeFirst();
        System.out.println(">List after removing first element: " + list);
        list.removeLast();
        System.out.println(">List after removing last element: " + list);

        list.clear();
        System.out.println(">List after clearing: " + list);
    }

    private static String printWithIterator(List list){
        Iterator iter = list.iterator();
        String elements = "";

        while (iter.hasNext()){
            elements = elements.concat(iter.next() + " ");
        }
        return elements;
    }
}
