package epam.nau.Task7.test;

import epam.nau.Task7.SpecialDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testSpecialDeposit {
    @Test
    void testIncome(){
        SpecialDeposit depo1 = new SpecialDeposit(BigDecimal.valueOf(5000), 3);
        SpecialDeposit depo2 = new SpecialDeposit(BigDecimal.valueOf(10000), 0);
        SpecialDeposit depo3 = new SpecialDeposit(BigDecimal.valueOf(1175), 4);
        Assertions.assertEquals(BigDecimal.valueOf(307), depo1.income());
        Assertions.assertEquals(BigDecimal.valueOf(0), depo2.income());
        Assertions.assertEquals(BigDecimal.valueOf(125), depo3.income());
    }
}
