package epam.nau.Task7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit{

    public LongDeposit(BigDecimal depositAmount, int depositPeriod){
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal income = new BigDecimal(0);
        BigDecimal amount = getAmount();
        if (getPeriod() > 6){
            for (int i = 0; i < getPeriod() - 6; i++) {
                BigDecimal temp = amount.multiply(BigDecimal.valueOf(0.15));
                income = income.add(temp);
                income = income.setScale(0, RoundingMode.HALF_EVEN);
                amount = amount.add(income);
            }
        }
        return income;
    }
}
