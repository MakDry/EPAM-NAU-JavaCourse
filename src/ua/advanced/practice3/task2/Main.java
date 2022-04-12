package ua.advanced.practice3.task2;

public class Main {
    public static void main(String[] args) {
        IntStringCappedMap map = new IntStringCappedMap(25);

        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");

        System.out.println(map);

        System.out.println("\n>Getting value with key \'8\': " + map.get(8));

    }
}
