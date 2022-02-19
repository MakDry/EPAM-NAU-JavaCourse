package ua.advanced.practice2.task2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.advanced.practice2.entity.City;
import ua.advanced.practice2.task2.QueueImpl;

import java.util.Iterator;

public class QueueImplTest {
    private QueueImpl queue;
    private static City kiyv = new City("Kiyv", 2_000_000, 504958, true);
    private static City lviv = new City("Lviv", 1_003_000, 495867, false);
    private static City kharkiv = new City("Kharkiv", 1_500_000, 495968, false);
    private Iterator iterator;

    @BeforeEach
    void testSetUp(){
        queue = new QueueImpl();
        queue.enqueue(kiyv);
        queue.enqueue(lviv);
        queue.enqueue(kharkiv);
        iterator = queue.iterator();
    }

    @Test
    void testSize(){
        Assertions.assertEquals(3, queue.size());
    }

    @Test
    void testTop(){
        Assertions.assertEquals("Kiyv", queue.top().getName());
    }

    @Test
    void testEnqueue(){
        QueueImpl testQueue = new QueueImpl();
        testQueue.enqueue(kiyv);
        testQueue.enqueue(lviv);
        Assertions.assertEquals("Kiyv", testQueue.top().getName());
        Assertions.assertEquals(2, testQueue.size());
    }

    @Test
    void testDequeue(){
        Assertions.assertEquals(3, queue.size());
        Assertions.assertEquals( "Kiyv", queue.dequeue().getName());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    void testIteratorNext(){
        Assertions.assertEquals(kiyv, iterator.next());
        Assertions.assertEquals(lviv, iterator.next());
        Assertions.assertEquals(kharkiv, iterator.next());
    }

    @Test
    void testIteratorHasNext(){
        Assertions.assertTrue(iterator.hasNext());
        iterator.next(); iterator.next(); iterator.next();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorRemove(){
        Assertions.assertEquals(3, queue.size());
        iterator.remove();
        Assertions.assertEquals(2, queue.size());
    }
}
