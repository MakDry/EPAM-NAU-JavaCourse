package epam.nau.Task5.test;

import epam.nau.Task5.ArrayRectangles;
import epam.nau.Task5.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testArrayRectangles {
    Rectangle rec1;
    Rectangle rec2;
    Rectangle rec3;
    Rectangle rec4;
    Rectangle rec5;
    Rectangle rec6;
    @Test
    void testNumberMaxArea(){
        rec1 = new Rectangle(4, 5);
        rec2 = new Rectangle(10, 4);
        rec3 = new Rectangle(2, 3);
        Rectangle[] rec_array1 = {rec1, rec2, rec3};
        ArrayRectangles obj_array1 = new ArrayRectangles(rec_array1);
        Assertions.assertEquals(1, obj_array1.numberMaxArea());

        rec4 = new Rectangle(2, 3);
        rec5 = new Rectangle(2, 2);
        rec6 = new Rectangle(7, 4);
        Rectangle[] rec_array2 = {rec4, rec5, rec6};
        ArrayRectangles obj_array2 = new ArrayRectangles(rec_array2);
        Assertions.assertEquals(2, obj_array2.numberMaxArea());
    }
    @Test
    void testNumberMinPerimeter(){
        rec1 = new Rectangle(4, 5);
        rec2 = new Rectangle(10, 4);
        rec3 = new Rectangle(2, 3);
        Rectangle[] rec_array1 = {rec1, rec2, rec3};
        ArrayRectangles obj_array1 = new ArrayRectangles(rec_array1);
        Assertions.assertEquals(2, obj_array1.numberMinPerimeter());

        rec4 = new Rectangle(2, 3);
        rec5 = new Rectangle(2, 2);
        rec6 = new Rectangle(7, 4);
        Rectangle[] rec_array2 = {rec4, rec5, rec6};
        ArrayRectangles obj_array2 = new ArrayRectangles(rec_array2);
        Assertions.assertEquals(1, obj_array2.numberMinPerimeter());
    }
    @Test
    void testNumberSquare(){
        rec1 = new Rectangle(4, 5);
        rec2 = new Rectangle(10, 4);
        rec3 = new Rectangle(2, 3);
        Rectangle[] rec_array1 = {rec1, rec2, rec3};
        ArrayRectangles obj_array1 = new ArrayRectangles(rec_array1);
        Assertions.assertEquals(0, obj_array1.numberSquare());

        rec4 = new Rectangle(2, 3);
        rec5 = new Rectangle(2, 2);
        rec6 = new Rectangle(7, 4);
        Rectangle[] rec_array2 = {rec4, rec5, rec6};
        ArrayRectangles obj_array2 = new ArrayRectangles(rec_array2);
        Assertions.assertEquals(1, obj_array2.numberSquare());
    }
    @Test
    void testAddRectangle(){
        rec1 = new Rectangle(4, 5);
        rec2 = new Rectangle(10, 4);
        rec3 = new Rectangle(2, 3);
        Rectangle[] arr = new Rectangle[3];
        arr[0] = rec1;
        arr[1] = rec2;
        ArrayRectangles arr_rec = new ArrayRectangles(arr);
        Assertions.assertEquals(true, arr_rec.addRectangle(rec3));

        arr = new Rectangle[2];
        arr[0] = rec1;
        arr[1] = rec2;
        Assertions.assertEquals(false, arr_rec.addRectangle(rec3));
    }
}
