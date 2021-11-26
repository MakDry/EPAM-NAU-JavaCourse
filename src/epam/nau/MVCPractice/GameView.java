package epam.nau.MVCPractice;

public class GameView {

    public void viewGameDetails(int rollNum, int randMin, int randMax) {
        System.out.println("Attempt №" + rollNum);
        System.out.println("Range of values: " + randMin + " <= X <= " + randMax);
        System.out.println("Enter the digit: ");
    }

    public void viewGameResult(String playerName, int rollNum) {
        System.out.println("\tCongratulations!");
        System.out.println(">Player name: " + playerName);
        System.out.println(">Attempts: " + rollNum);
    }
}
