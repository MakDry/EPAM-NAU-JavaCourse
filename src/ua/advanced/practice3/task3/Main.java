package ua.advanced.practice3.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PairStringList stringList = new PairStringList();

        List<String> listCollection1 = new ArrayList<>();
        listCollection1.add("Java");
        listCollection1.add("C#");

        List<String> listCollection2 = new ArrayList<>();
        listCollection2.add("C++");
        listCollection2.add("Rust");

        stringList.add("Operation System");
        stringList.add("Object Oriented Programming");
        stringList.add("Java");
        stringList.add("Backup");

        System.out.println(">Pair String List after adding: ");
        System.out.println(stringList);

        System.out.println("\n>Pair String List after adding by indexes: ");
        stringList.add("Programmer", 3);
        stringList.add("Developer", 4);
        System.out.println(stringList);

        System.out.println("\n>Result of removing object \'Java\': " + stringList.remove("Java"));
        System.out.println(">Result of removing: ");
        System.out.println(stringList);

        System.out.println("\n>Result of removing object \'Operation System\': " + stringList.remove("Operation System"));
        System.out.println(">Result of removing: ");
        System.out.println(stringList);

        System.out.println("\n>Result of removing object with index \'3\': " + stringList.remove(3));
        System.out.println(">Result of removing: ");
        System.out.println(stringList);

        System.out.println("\n>Getting object with index \'0\': " + stringList.get(0));
        System.out.println(">Getting object with index \'4\': " + stringList.get(4));

        System.out.println("\n>Result of the setting \'Operation System\' with index \'3\': " + stringList.set("Operation System", 3));
        System.out.println(stringList);

        System.out.println("\n>Pair String List after adding collection \'listCollection1\': ");
        stringList.addCollection(listCollection1);
        System.out.println(stringList);

        System.out.println("\n>Pair String List after adding collection \'listCollection2\' witch index \'4\': ");
        stringList.addCollection(listCollection2, 4);
        System.out.println(stringList);

        System.out.println("\n>Output by iterator: ");
        for (String value : stringList) {
            System.out.println(value);
        }
    }
}
