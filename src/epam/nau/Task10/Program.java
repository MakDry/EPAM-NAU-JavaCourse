package epam.nau.Task10;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        UserKMDAHelper helper = new UserKMDAHelper();
        List<User> usersData = helper.getUserFromURL();
        System.out.println(">Users data list: \n" + usersData);
        System.out.println("\n>Max salary in three months: " + helper.maxSalary(usersData) + " ₴");
        System.out.println("\n>Users with min salary in three months:\n" + helper.minSalary(usersData));
        System.out.println("\n>Users with average salary in three months:\n" + helper.averageSalary(usersData));
        System.out.println("\n>Average salary for each month: ");
        double[] data = helper.averageSalaryPerMonth();
        for (int i = 0; i < data.length; i++) {
            System.out.println(helper.getMonths()[i] + " - " + data[i] + " ₴");
        }
        System.out.println("\n>Biggest salary confirmed in " + helper.biggestSalary() + " ₴");
    }
}
