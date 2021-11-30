package epam.nau.Task7;

import java.math.BigDecimal;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Client client = new Client();

        int option = 0;
        while (option != -1){
            System.out.println("\t\tWelcome to Deposit Window");
            System.out.println("\n>Please, enter the following values: ");
            System.out.println("1) Enter the deposit amount: ");
            double temp = input.nextDouble();
            BigDecimal amount = new BigDecimal(temp);
            System.out.println("2) Enter the deposit period: ");
            int period = input.nextInt();
            System.out.println("3) Choose the type of deposit: ");
            System.out.println("   1. Base deposit");
            System.out.println("   2. Special deposit");
            System.out.println("   3. Long deposit");
            switch (input.nextInt()){
                case 1:
                    BaseDeposit baseDeposit = new BaseDeposit(amount, period);
                    if (client.addDeposit(baseDeposit) == true){
                        System.out.println(">Your new deposit was successfully added<");
                    } else {
                        System.out.println(">You have reached the deposit limit<");
                    }
                    System.out.println("\n>Your deposit statistic: ");
                    System.out.println("1) The initial amount of the deposit: " + baseDeposit.getAmount());
                    System.out.println("2) Deposit period: " + baseDeposit.getPeriod());
                    System.out.println("3) Total income: " + baseDeposit.income());
                    System.out.println("4) The amount of the deposit after the deposit period: " + baseDeposit.getAmount().add(baseDeposit.income()));
                    System.out.println("5) Total income from all deposits: " + client.totalIncome());
                    System.out.println("6) Maximum income from deposits: " + client.maxIncome());
                    break;

                case 2:
                    SpecialDeposit specialDeposit = new SpecialDeposit(amount, period);
                    if (client.addDeposit(specialDeposit) == true){
                        System.out.println(">Your new deposit was successfully added<");
                    } else {
                        System.out.println(">You have reached the deposit limit<");
                    }
                    System.out.println("\n>Your deposit statistic: ");
                    System.out.println("1) The initial amount of the deposit: " + specialDeposit.getAmount());
                    System.out.println("2) Deposit period: " + specialDeposit.getPeriod());
                    System.out.println("3) Total income: " + specialDeposit.income());
                    System.out.println("4) The amount of the deposit after the deposit period: " + specialDeposit.getAmount().add(specialDeposit.income()));
                    System.out.println("5) Total income from all deposits: " + client.totalIncome());
                    System.out.println("6) Maximum income from deposits: " + client.maxIncome());
                    break;

                case 3:
                    LongDeposit longDeposit = new LongDeposit(amount, period);
                    if (client.addDeposit(longDeposit) == true){
                        System.out.println(">Your new deposit was successfully added<");
                    } else {
                        System.out.println(">You have reached the deposit limit<");
                    }
                    System.out.println("\n>Your deposit statistic: ");
                    System.out.println("1) The initial amount of the deposit: " + longDeposit.getAmount());
                    System.out.println("2) Deposit period: " + longDeposit.getPeriod());
                    System.out.println("3) Total income: " + longDeposit.income());
                    System.out.println("4) The amount of the deposit after the deposit period: " + longDeposit.getAmount().add(longDeposit.income()));
                    System.out.println("5) Total income from all deposits: " + client.totalIncome());
                    System.out.println("6) Maximum income from deposits: " + client.maxIncome());
                    break;

                default:
                    break;
            }
            System.out.println("\nP.S. Print 1 to continue, or -1 to exit.");
            option = input.nextInt();
        }
    }
}