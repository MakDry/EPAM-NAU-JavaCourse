package epam.nau.Task5.test;

import epam.nau.Task5.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testRectangle {
    @Test
    void testArea(){
        Rectangle rect = new Rectangle(6, 5);
        Assertions.assertEquals(30, rect.area());
        rect = new Rectangle(10, 5);
        Assertions.assertEquals(50, rect.area());
        rect = new Rectangle(1, 3);
        Assertions.assertEquals(3, rect.area());
    }

    @Test
    void testPerimeter(){
        Rectangle rect = new Rectangle(6, 5);
        Assertions.assertEquals(22, rect.perimeter());
        rect = new Rectangle(10, 5);
        Assertions.assertEquals(30, rect.perimeter());
        rect = new Rectangle(1, 3);
        Assertions.assertEquals(8, rect.perimeter());
    }

    @Test
    void testIsSquare(){
        Rectangle rect = new Rectangle(6, 5);
        Assertions.assertEquals(false, rect.isSquare());
        rect = new Rectangle(10, 10);
        Assertions.assertEquals(true, rect.isSquare());
        rect = new Rectangle(2, 3);
        Assertions.assertEquals(false, rect.isSquare());
    }
}
