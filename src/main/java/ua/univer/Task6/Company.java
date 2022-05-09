package ua.univer.Task6;

import java.math.BigDecimal;

public class Company {

    private Employee[] staff;

    public Company(Employee[] arr) {
        this.staff = arr;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {
        for (var employee : staff) {
            employee.setBonus(companyBonus);
        }
    }

    public double totalToPay(){
        BigDecimal totalToPay = new BigDecimal(0);
        for (var employee : staff) {
            totalToPay = totalToPay.add(employee.toPay());
        }
        return totalToPay.doubleValue();
    }

    public String nameMaxSalary(){
        BigDecimal maxSalary = new BigDecimal(0);
        String name = "Default";
        for (var employee : staff) {
            BigDecimal totalToPay = new BigDecimal(0);
            BigDecimal temp = totalToPay.add(employee.getSalary());
            totalToPay = temp.add(employee.bonus);
            int compare = totalToPay.compareTo(maxSalary);
            if (compare == 1){
                name = employee.getName();
                maxSalary = totalToPay;
            }
        }
        return name;
    }
}
