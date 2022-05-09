package ua.univer.Task7;

import java.math.BigDecimal;

public class Client {

    private Deposit[] deposits;

    public Client() {
        deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        if (deposits[9] != null) {
            return false;
        }
        for (int i = 0; i < deposits.length - 1; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal totalIncome = new BigDecimal(0);
        for (var deposit : deposits) {
            if (deposit != null) {
                BigDecimal income = deposit.income();
                totalIncome = totalIncome.add(income);
            }
        }
        return totalIncome;
    }

    public BigDecimal maxIncome() {
        BigDecimal maxIncome = new BigDecimal(0);
        for (var deposit : deposits) {
            if (deposit != null) {
                BigDecimal income = deposit.income();
                int compare = maxIncome.compareTo(income);
                if (compare == -1) {
                    maxIncome = income;
                }
            }
        }
        return maxIncome;
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (deposits[number - 1] != null) {
            return deposits[number - 1].income();
        }
        return BigDecimal.valueOf(0);
    }
}
