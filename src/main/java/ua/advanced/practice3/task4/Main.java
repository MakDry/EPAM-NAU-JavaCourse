package ua.advanced.practice3.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbsoluteValueIntegerSet integerSet = new AbsoluteValueIntegerSet();
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(1);
        list.add(7);
        list.add(9);

        integerSet.add(10);
        integerSet.add(2);
        integerSet.add(1);
        integerSet.add(3);
        integerSet.add(5);
        System.out.println(">Integer set after adding: ");
        System.out.println(integerSet);

        System.out.println("\n>Result of removing value \'3\': " + integerSet.remove(3));
        System.out.println(">Result of removing value \'13\': " + integerSet.remove(13));
        System.out.println(">Result of removing: ");
        System.out.println(integerSet);

        System.out.println("\n>Result of searching element with value \'5\': " + integerSet.search(5));
        System.out.println(">Result of searching element with value \'13\': " + integerSet.search(13));

        System.out.println("\n>Result of adding a collection to Integer Set: ");
        integerSet.addCollection(list);
        System.out.println(integerSet);

        System.out.println("\n>Output by iterator: ");
        for (Integer value : integerSet) {
            System.out.print(value + ", ");
        }
    }
}