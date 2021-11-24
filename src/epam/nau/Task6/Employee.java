package epam.nau.Task6;

import java.math.BigDecimal;

public abstract class Employee {

    private String name;
    private BigDecimal salary;
    protected BigDecimal bonus;

    public Employee(String lastName, double salaryValue) {
        this.name = lastName;
        this.salary = new BigDecimal(salaryValue);
    }

    public Employee() {
        this.name = "Default";
        this.salary = new BigDecimal(0.0);
        this.bonus = new BigDecimal(0.0);
    }

    public abstract void setBonus(BigDecimal bonus);

    public BigDecimal toPay() {
        return salary.add(bonus);
    }

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(double value) {
        this.salary = new BigDecimal(value);
    }

}
