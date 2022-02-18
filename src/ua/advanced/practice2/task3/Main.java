package ua.advanced.practice2.task3;

import ua.advanced.practice2.entity.City;
import ua.advanced.practice2.entity.XMLDeserialization;

import java.util.Iterator;

public class Main {
    private static City kyiv;
    private static City lviv;
    private static City cherkasy;
    private static City kharkiv;
    private static City zaporizhzhiya;
    private static City[] cities;

    static{
        cities = XMLDeserialization.deserializeFromXml();
        kyiv = cities[0];
        lviv = cities[1];
        cherkasy = cities[2];
        kharkiv = cities[3];
        zaporizhzhiya = cities[4];
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(kyiv);
        stack.push(lviv);
        stack.push(cherkasy);
        stack.push(kharkiv);
        System.out.println(">Stack after pushing elements: " + stack);
        System.out.println(">Stack size: " + stack.size());
        System.out.println(">Pop top element from stack: " + stack.pop());
        System.out.println("\n>Stack after popping: " + stack);
        System.out.println(">Getting the top element from stack: " + stack.top());

        System.out.println("\n>Stack output by iterator: " + printWithIterator(stack));

        stack.iterator().remove();
        System.out.println("\n>Stack after removing last iteration element by iterator: " + printWithIterator(stack));

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
