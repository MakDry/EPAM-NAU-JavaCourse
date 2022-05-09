package ua.univer.Task7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit{

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod){
        super(depositAmount, depositPeriod);
    }


    @Override
    public BigDecimal income() {
        BigDecimal income = new BigDecimal(0);
        BigDecimal amount = getAmount();
        for (int i = 0; i < getPeriod(); i++) {
            BigDecimal temp = amount.multiply(BigDecimal.valueOf(0.05));
            income = income.add(temp);
            income = income.setScale(0, RoundingMode.HALF_EVEN);
            amount = amount.add(income);
        }
        return income;
    }
}
