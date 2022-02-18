package ua.advanced.practice2.task3;

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
        StackImpl stack = new StackImpl();
        stack.push(A);
        stack.push(B);
        stack.push(C);
        stack.push(D);
        System.out.println(">Stack after pushing elements: " + stack);
        System.out.println(">Stack size: " + stack.size());
        System.out.println(">Pop top element from stack: " + stack.pop());
        System.out.println(">Stack after popping: " + stack);
        System.out.println(">Getting the top element from stack: " + stack.top());

        System.out.println(">Stack output by iterator: " + printWithIterator(stack));

        stack.iterator().remove();
        System.out.println(">Stack after removing last iteration element by iterator: " + printWithIterator(stack));

        stack.clear();
        System.out.println(">Stack after clearing: " + stack);
    }

    private static String printWithIterator(StackImpl stack){
        Iterator iter = stack.iterator();
        String elements = "";

        while (iter.hasNext()){
            elements = elements.concat(iter.next() + " ");
        }
        return elements;
    }
}
