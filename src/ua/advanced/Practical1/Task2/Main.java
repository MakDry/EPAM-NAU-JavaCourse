package ua.advanced.Practical1.Task2;

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

        System.out.println(">Array output by iterator: " + array.iterator());

        System.out.println(">Getting next object by iterator: " + array.iterator().next());

        array.iterator().remove();
        System.out.println(">Array after removing (index 0) object by iterator: " + array.iterator());

        array.clear();
        System.out.println(">Array after clearing: " + array);
    }
}