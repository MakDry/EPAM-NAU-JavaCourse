package ua.univer.Task5.test;

import ua.univer.Task5.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testRectangle {
    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;

    @BeforeEach
    void setUpTest() {
        rect1 = new Rectangle(6, 5);
        rect2 = new Rectangle(10, 5);
        rect3 = new Rectangle(1, 3);
    }

    @Test
    void testArea() {

        Assertions.assertEquals(30, rect1.area());
        Assertions.assertEquals(50, rect2.area());
        Assertions.assertEquals(3, rect3.area());
    }

    @Test
    void testPerimeter() {
        Assertions.assertEquals(22, rect1.perimeter());
        Assertions.assertEquals(30, rect2.perimeter());
        Assertions.assertEquals(8, rect3.perimeter());
    }

    @Test
    void testIsSquare() {
        Assertions.assertEquals(false, rect1.isSquare());
        rect2 = new Rectangle(5, 5);
        Assertions.assertEquals(true, rect2.isSquare());
        Assertions.assertEquals(false, rect3.isSquare());
    }
}
