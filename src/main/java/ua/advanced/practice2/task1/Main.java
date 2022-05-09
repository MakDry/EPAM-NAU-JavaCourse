package ua.advanced.practice2.task1;

import ua.advanced.practice2.entity.City;
import ua.advanced.practice2.entity.JSONSerializer;
import ua.advanced.practice2.entity.XMLDeserialization;

import java.util.Iterator;

public class Main {
    private static City kyiv;
    private static City lviv;
    private static City cherkasy;
    private static City kharkiv;
    private static City zaporizhzhiya;
    private static City[] cities;
    private static final String FILE_PATH;

    static{
        cities = XMLDeserialization.deserializeFromXml();
        kyiv = cities[0];
        lviv = cities[1];
        cherkasy = cities[2];
        kharkiv = cities[3];
        zaporizhzhiya = cities[4];
        FILE_PATH = "resources\\practice2\\ListData.json";
    }

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst(lviv);
        list.addFirst(kyiv);
        list.addLast(cherkasy);
        list.addLast(kharkiv);
        System.out.println(">List after adding new objects: " + list);
        System.out.println(">List size: " + list.size());
        JSONSerializer.serializeToJson(list, FILE_PATH);

        System.out.println(">Try to delete object \'Zaporizhzhiya\': " + list.remove(zaporizhzhiya));
        System.out.println(">List after unsuccessful removing the object \'Zaporizhzhiya\': " + list);
        System.out.println(">Try to delete object \'Kharkiv\': " + list.remove(kharkiv));
        System.out.println(">List after removing the object \'Kharkiv\': " + list);

        System.out.println(">Using method getFirst(): " + list.getFirst());
        System.out.println("\n>Using method getLast(): " + list.getLast());

        System.out.println("\n>Searching for object \'Zaporizhzhiya\': " + list.search(zaporizhzhiya));
        System.out.println(">Searching for object \'Kyiv\': " + list.search(kyiv));

        System.out.println("\n>List output by iterator: " + printWithIterator(list));

        list.removeFirst();
        System.out.println("\n>List after removing first element: " + list);
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
