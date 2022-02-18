package ua.advanced.practice2.task2;

import java.util.Iterator;

public class Main {
    private static Object A;
    private static Object B;
    private static Object C;
    private static Object D;

    static{
        A = "A";
        B = "B";
        C = "C";
        D = "D";
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(A);
        queue.enqueue(B);
        queue.enqueue(C);
        queue.enqueue(D);
        System.out.println(">Queue after adding new objects: " + queue);
        System.out.println(">Queue size: " + queue.size());

        System.out.println(">Removed head: " + queue.dequeue());
        System.out.println(">Queue after head removing: " + queue);

        System.out.println(">The head of the queue: " + queue.top());

        queue.iterator().remove();
        System.out.println(">Queue after removing first element by iterator: " + queue);

        System.out.println(">Queue output by iterator: " + printWithIterator(queue));
    }

    private static String printWithIterator(QueueImpl queue){
        Iterator iter = queue.iterator();
        String elements = "";

        while (iter.hasNext()){
            elements = elements.concat(iter.next() + " ");
        }
        return elements;
    }
}
