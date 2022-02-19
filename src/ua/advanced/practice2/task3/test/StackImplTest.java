package ua.advanced.practice2.task3.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.advanced.practice2.entity.City;
import ua.advanced.practice2.task3.StackImpl;

import java.util.Iterator;

public class StackImplTest {
    private StackImpl stack;
    private static City kiyv = new City("Kiyv", 2_000_000, 504958, true);
    private static City lviv = new City("Lviv", 1_003_000, 495867, false);
    private static City kharkiv = new City("Kharkiv", 1_500_000, 495968, false);
    private Iterator iterator;

    @BeforeEach
    void testSetUp(){
        stack = new StackImpl();
        stack.push(kiyv);
        stack.push(lviv);
        stack.push(kharkiv);
        iterator = stack.iterator();
    }

    @Test
    void testSize(){
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    void testTop(){
        Assertions.assertEquals(kharkiv, stack.top());
        stack.push(kiyv);
        Assertions.assertEquals(kiyv, stack.top());
    }

    @Test
    void testPush(){
        StackImpl testStack = new StackImpl();
        testStack.push(kiyv);
        Assertions.assertEquals(1, testStack.size());
        Assertions.assertEquals(kiyv, testStack.top());
    }

    @Test
    void testPop(){
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals(kharkiv, stack.pop());
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    void testIteratorNext(){
        Assertions.assertEquals(kharkiv, iterator.next());
        Assertions.assertEquals(lviv, iterator.next());
        Assertions.assertEquals(kiyv, iterator.next());
    }

    @Test
    void testIteratorHasNext(){
        Assertions.assertTrue(iterator.hasNext());
        iterator.next(); iterator.next(); iterator.next();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorRemove(){
        Assertions.assertEquals(3, stack.size());
        iterator.remove();
        Assertions.assertEquals(2, stack.size());
    }
}
