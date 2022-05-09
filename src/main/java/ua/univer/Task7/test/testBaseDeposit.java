package ua.univer.Task7.test;

import ua.univer.Task7.BaseDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testBaseDeposit {
    @Test
    void testIncome(){
        BaseDeposit depo1 = new BaseDeposit(BigDecimal.valueOf(11500), 3);
        BaseDeposit depo2 = new BaseDeposit(BigDecimal.valueOf(12500), 1);
        BaseDeposit depo3 = new BaseDeposit(BigDecimal.valueOf(1175), 6);
        Assertions.assertEquals( BigDecimal.valueOf(1842), depo1.income());
        Assertions.assertEquals( BigDecimal.valueOf(625), depo2.income());
        Assertions.assertEquals( BigDecimal.valueOf(464), depo3.income());
    }
}
