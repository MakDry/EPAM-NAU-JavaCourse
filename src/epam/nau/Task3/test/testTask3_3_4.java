package epam.nau.Task3.test;

import epam.nau.Task3.Task3_3.Arithmetic_3;
import epam.nau.Task3.Task3_4.Arithmetic_4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testTask3_3_4 {
    @Test
    public void testMultiArithmeticElements() {
        int result1 = Arithmetic_3.MultArithmeticElements(8, 5, 3);
        Assertions.assertEquals(418880, result1);
        int result2 = Arithmetic_3.MultArithmeticElements(-4, 3, 10);
        Assertions.assertEquals(-384, result2);
        int result3 = Arithmetic_3.MultArithmeticElements(12, 4, 2);
        Assertions.assertEquals(48384, result3);
    }

    @Test
    public void testSumGeometricElements() {
        int result1 = Arithmetic_4.SumGeometricElements(200, 0.7, 30);
        Assertions.assertEquals(589, result1);
        int result2 = Arithmetic_4.SumGeometricElements(500, 0.5, 50);
        Assertions.assertEquals(938, result2);
        int result3 = Arithmetic_4.SumGeometricElements(737, 0.3, 74);
        Assertions.assertEquals(958, result3);
    }
}