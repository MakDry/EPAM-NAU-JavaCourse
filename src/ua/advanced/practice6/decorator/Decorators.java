package ua.advanced.practice6.decorator;

import java.util.ArrayList;
import java.util.List;

public class Decorators {
//    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
//        throw new UnsupportedOperationException();
//    }
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        List<String> indexedList = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i += 2) {
            indexedList.add(sourceList.get(i));
        }
        return indexedList;
    }
}
