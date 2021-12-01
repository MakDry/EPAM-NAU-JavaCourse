package epam.nau.MVCPractice;

public class GameView {

    public static final String ADD_USERNAME = ">Enter your username: ";
    public static final String NUMBER_OF_PLAYERS = ">Enter the number of players: ";
    public static final String WRONG_INPUT_DATA = "!Wrong value!";
    public static final String ADD_MIN = ">Enter the min value: ";
    public static final String ADD_MAX = ">Enter the max value: ";
    public static final String INPUT_DIGIT = "Enter the digit: ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void viewGameDetails(int rollNum, int randMin, int randMax) {
        System.out.println("Attempt №" + rollNum);
        System.out.println("Range of values: " + randMin + " < X < " + randMax);
    }

    public void viewGameResult(String playerName, int rollNum) {
        System.out.println("\tCongratulations!");
        System.out.println(">Player name: " + playerName);
        System.out.println(">Attempts: " + rollNum + "\n");
    }
}
