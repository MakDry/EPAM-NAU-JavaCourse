package epam.nau.Task6.test;

import epam.nau.Task6.Company;
import epam.nau.Task6.Employee;
import epam.nau.Task6.Manager;
import epam.nau.Task6.SalesPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class testTask6 {
    Manager person1;
    Manager person2;
    Manager person3;
    SalesPerson person4;
    SalesPerson person5;
    SalesPerson person6;
    Company workStaff;

    @BeforeEach
    private void setUpTest(){
        person1 = new Manager("Jonathan", 10500, 120);
        person2 = new Manager("Lighter", 10174, 57);
        person3 = new Manager("Jordan", 10250, 152);
        person4 = new SalesPerson("Slighter", 7460, 76);
        person5 = new SalesPerson("Righter", 7307, 145);
        person6 = new SalesPerson("Hoft", 7677, 211);

    }
    @Test
    void testTotalToPay(){
        Employee[] arr = new Employee[]{person1, person3, person4, person2, person6, person5};
        workStaff = new Company(arr);
        workStaff.giveEverybodyBonus(new BigDecimal(3000));
        Assertions.assertEquals(81868, workStaff.totalToPay());
    }
    @Test
    void testNameMaxSalary(){
        Employee[] arr = new Employee[]{person3, person6, person2, person4, person5, person1};
        workStaff = new Company(arr);
        workStaff.giveEverybodyBonus(new BigDecimal(3000));
        Assertions.assertEquals("Hoft", workStaff.nameMaxSalary());
    }
}
