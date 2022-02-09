package ua.univer.Task7.test;

import ua.univer.Task7.BaseDeposit;
import ua.univer.Task7.Client;
import ua.univer.Task7.LongDeposit;
import ua.univer.Task7.SpecialDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testClient {
    Client client1;
    Client client2;
    BaseDeposit baseDeposit;
    LongDeposit longDeposit;
    SpecialDeposit specialDeposit;
    @BeforeEach
    void setUpTest(){
        client1 = new Client();
        client2 = new Client();
        baseDeposit = new BaseDeposit(BigDecimal.valueOf(11250), 3);
        longDeposit = new LongDeposit(BigDecimal.valueOf(30000), 7);
        specialDeposit = new SpecialDeposit(BigDecimal.valueOf(5000), 5);

    }
    @Test
    void testAddDeposit(){
        Assertions.assertEquals(true, client1.addDeposit(baseDeposit));
        Assertions.assertEquals(true, client1.addDeposit(baseDeposit));
        Assertions.assertEquals(true, client1.addDeposit(baseDeposit));
        Assertions.assertEquals(true, client1.addDeposit(longDeposit));
        Assertions.assertEquals(true, client1.addDeposit(longDeposit));
        Assertions.assertEquals(true, client1.addDeposit(longDeposit));
        Assertions.assertEquals(true, client1.addDeposit(longDeposit));
        Assertions.assertEquals(true, client1.addDeposit(specialDeposit));
        Assertions.assertEquals(true, client1.addDeposit(specialDeposit));
        Assertions.assertEquals(false, client1.addDeposit(specialDeposit));
        Assertions.assertEquals(false, client1.addDeposit(specialDeposit));
    }
    @Test
    void testTotalIncome(){
        client1.addDeposit(baseDeposit);
        client1.addDeposit(specialDeposit);
        client1.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(specialDeposit);
        Assertions.assertEquals( BigDecimal.valueOf(7130), client1.totalIncome());
        Assertions.assertEquals(BigDecimal.valueOf(9829), client2.totalIncome());
    }
    @Test
    void testMaxIncome(){
        client1.addDeposit(baseDeposit);
        client1.addDeposit(baseDeposit);
        client1.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(specialDeposit);
        Assertions.assertEquals(BigDecimal.valueOf(4500), client1.maxIncome());
        Assertions.assertEquals(BigDecimal.valueOf(4500), client2.maxIncome());
    }
    @Test
    void testGetIncomeByNumber(){
        client1.addDeposit(baseDeposit);
        client1.addDeposit(baseDeposit);
        client1.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(longDeposit);
        client2.addDeposit(specialDeposit);
        Assertions.assertEquals(BigDecimal.valueOf(4500), client1.getIncomeByNumber(3));
        Assertions.assertEquals(BigDecimal.valueOf(1801), client1.getIncomeByNumber(2));
    }
}
