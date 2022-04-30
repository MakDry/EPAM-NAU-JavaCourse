package ua.advanced.practice6.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        List<Integer> intList = new ArrayList<>();
        for (int value : array) {
            intList.add(value);
            intList.add(value);
        }
        return intList.iterator();
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        List<Integer> intList = new ArrayList<>();
        for (int value : array) {
            for (int i = 0; i < 3; i++) {
                intList.add(value);
            }
        }
        return intList.iterator();
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        List<Integer> intList = new ArrayList<>();
        for (int value : array) {
            for (int i = 0; i < 5; i++) {
                intList.add(value);
            }
        }
        return intList.iterator();
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        List<String> stringList = new ArrayList<>();
        for (String value : columns) {
            for (int intValue : rows) {
                stringList.add(value + intValue);
            }
        }
        return () -> stringList.iterator();
    }
}
