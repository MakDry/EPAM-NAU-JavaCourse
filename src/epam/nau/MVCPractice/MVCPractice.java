package epam.nau.MVCPractice;

import java.util.Scanner;

public class MVCPractice {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println(">Enter user name: ");
        String userName = userInput.nextLine();
        System.out.println(">Enter the min value: ");
        int min = userInput.nextInt();
        System.out.println(">Enter the max value: ");
        int max = userInput.nextInt();

        GameController controller = new GameController(userName, min, max);
        controller.gamePlay(0);
    }
}
