package epam.nau.Task7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit{

    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod){
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal income = new BigDecimal(0);
        BigDecimal amount = getAmount();
        BigDecimal percent = new BigDecimal(0.01);
        for (int i = 0; i < getPeriod(); i++) {
            BigDecimal temp = amount.multiply(percent);
            income = income.add(temp);
            income = income.setScale(0, RoundingMode.HALF_EVEN);
            amount = amount.add(income);
            percent = percent.add(BigDecimal.valueOf(0.01));
        }
        return income;
    }
}
