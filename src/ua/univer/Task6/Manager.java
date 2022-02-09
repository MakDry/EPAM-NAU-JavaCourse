package ua.univer.Task6;

import java.math.BigDecimal;

public class Manager extends Employee {

    private int quantity;

    public Manager(String lastName, double salaryValue, int clientAmount) {
        super(lastName, salaryValue);
        this.quantity = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonusValue) {
        if (quantity > 100 && quantity < 150) {
            super.bonus = bonusValue.add(BigDecimal.valueOf(500));
            return;
        } else if (quantity > 150) {
            super.bonus = bonusValue.add(BigDecimal.valueOf(1000));
            return;
        }
        super.bonus = bonusValue;
    }
}
