package epam.nau.Task6;

import java.math.BigDecimal;

public class SalesPerson extends Employee {

    private int percent;

    public SalesPerson(String lastName, double salaryValue, int percentValue) {
        super(lastName, salaryValue);
        this.percent = percentValue;
    }

    @Override
    public void setBonus(BigDecimal bonusValue) {
        if (percent > 100 && percent < 200) {
            super.bonus = bonusValue.multiply(BigDecimal.valueOf(2));
            return;
        } else if (percent > 200) {
            super.bonus = bonusValue.multiply(BigDecimal.valueOf(3));
            return;
        }
        super.bonus = bonusValue;
    }
}
