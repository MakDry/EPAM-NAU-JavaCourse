package ua.advanced.practice2.task2;

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
        FILE_PATH = "resources\\practice2\\QueueData.json";
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(kyiv);
        queue.enqueue(lviv);
        queue.enqueue(cherkasy);
        queue.enqueue(kharkiv);
        System.out.println(">Queue after adding new objects: " + queue);
        System.out.println(">Queue size: " + queue.size());
        JSONSerializer.serializeToJson(queue, FILE_PATH);

        System.out.println(">Removed head: " + queue.dequeue());
        System.out.println("\n>Queue after head removing: " + queue);

        System.out.println(">The head of the queue: " + queue.top());

        queue.iterator().remove();
        System.out.println("\n>Queue after removing first element by iterator: " + queue);

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
