package ua.univer.Task7.test;

import ua.univer.Task7.LongDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testLongDeposit {
    @Test
    void testIncome(){
        LongDeposit depo1 = new LongDeposit(BigDecimal.valueOf(10000), 6);
        LongDeposit depo2 = new LongDeposit(BigDecimal.valueOf(10000), 8);
        LongDeposit depo3 = new LongDeposit(BigDecimal.valueOf(12500), 10);
        Assertions.assertEquals(BigDecimal.valueOf(0), depo1.income());
        Assertions.assertEquals(BigDecimal.valueOf(3225), depo2.income());
        Assertions.assertEquals(BigDecimal.valueOf(10572), depo3.income());
    }
}
