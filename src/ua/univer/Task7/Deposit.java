package ua.univer.Task7;

import java.math.BigDecimal;

public abstract class Deposit {
    private BigDecimal amount;
    private int period;

    protected Deposit(BigDecimal depositAmount, int depositPeriod){
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    protected Deposit(){
        this.amount = BigDecimal.valueOf(0);
        this.period = 0;
    }

    abstract BigDecimal income();

    public int getPeriod() {
        return period;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
