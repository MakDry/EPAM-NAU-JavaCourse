package ua.advanced.practice2.task1.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.advanced.practice2.entity.City;
import ua.advanced.practice2.task1.ListImpl;

import java.util.Iterator;

public class ListImplTest {
    private ListImpl list;
    private static City kiyv = new City("Kiyv", 2_000_000, 504958, true);
    private static City lviv = new City("Lviv", 1_003_000, 495867, false);
    private static City kharkiv = new City("Kharkiv", 1_500_000, 495968, false);
    private Iterator iterator;

    @BeforeEach
    void testSetUp(){
        list = new ListImpl();
        iterator = list.iterator();
        list.addFirst(kiyv);
        list.addLast(lviv);
        list.addFirst(kharkiv);
    }

    @Test
    void testSize(){
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void testGetFirst(){
        Assertions.assertEquals("Kharkiv", list.getFirst().getName());
    }

    @Test
    void testGetLast(){
        Assertions.assertEquals("Lviv", list.getLast().getName());
    }

    @Test
    void testAddFirst(){
        ListImpl testList = new ListImpl();
        testList.addFirst(kiyv);
        Assertions.assertEquals("Kiyv", testList.getFirst().getName());
        Assertions.assertEquals(1, testList.size());
    }

    @Test
    void testAddLast(){
        ListImpl testList = new ListImpl();
        testList.addFirst(kiyv);
        testList.addLast(kharkiv);
        Assertions.assertEquals("Kharkiv", testList.getLast().getName());
        Assertions.assertEquals(2, testList.size());
    }

    @Test
    void testRemoveFirst(){
        list.removeFirst();
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Kiyv", list.getFirst().getName());
        Assertions.assertEquals("Lviv", list.getLast().getName());
    }

    @Test
    void testRemoveLast(){
        list.removeLast();
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("Kharkiv", list.getFirst().getName());
        Assertions.assertEquals("Kiyv", list.getLast().getName());
    }

    @Test
    void testSearch(){
        Assertions.assertNull(list.search(new City()));
        Assertions.assertEquals(kiyv, list.search(kiyv));
        Assertions.assertEquals(lviv, list.search(lviv));
    }

    @Test
    void testRemove(){
        Assertions.assertFalse(list.remove(new City()));
        Assertions.assertTrue(list.remove(kiyv));
    }

    @Test
    void testIteratorNext(){
        Assertions.assertEquals(kharkiv, iterator.next());
        Assertions.assertEquals(kiyv, iterator.next());
        Assertions.assertEquals(lviv, iterator.next());
    }

    @Test
    void testIteratorHasNext(){
        Assertions.assertTrue(iterator.hasNext());
        iterator.next(); iterator.next(); iterator.next();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorRemove(){
        iterator.remove();
        Assertions.assertEquals(2, list.size());
    }
}
