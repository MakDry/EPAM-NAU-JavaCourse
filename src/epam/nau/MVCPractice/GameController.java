package epam.nau.MVCPractice;

import java.util.Scanner;

public class GameController {
    private Game game;
    private GameView gameView;
    private Scanner input = new Scanner(System.in);

    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void gameProcessing() {
        int numberOfPlayers = inputNumberOfPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            playersProcessing();
            gameplay();
            gameView.viewGameResult(game.getUsername(), game.getRollNum());
        }
    }

    private void playersProcessing() {
        String playerName = inputUsername();
        int min = inputMin();
        int max = inputMax();
        game = new Game(playerName, min, max);
    }

    private void gameplay() {
        int digit = 0;
        int attemptNumb = 0;
        while (digit != game.getTrueDigit()) {
            gameView.viewGameDetails(game.getRollNum(), game.getRandMin(), game.getRandMax());
            digit = inputDigit();
            if (digit > game.getTrueDigit() && digit < game.getRandMax()) {
                game.setRandMax(digit);
            } else if (digit < game.getTrueDigit() && digit > game.getRandMin()) {
                game.setRandMin(digit);
            }
            attemptNumb++;
            game.setRollNum(attemptNumb);
        }
    }

    private int inputNumberOfPlayers() {
        gameView.printMessage(GameView.NUMBER_OF_PLAYERS);
        while (!input.hasNextInt()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            input.next();
        }
        return input.nextInt();
    }

    private String inputUsername() {
        gameView.printMessage(GameView.ADD_USERNAME);
        while (!input.hasNextLine()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            input.next();
        }
        input.nextLine();
        String userName = input.nextLine();
        return userName;
    }

    private int inputMin() {
        gameView.printMessage(GameView.ADD_MIN);
        while (!input.hasNextInt()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            input.next();
        }
        return input.nextInt();
    }

    private int inputMax() {
        gameView.printMessage(GameView.ADD_MAX);
        while (!input.hasNextInt()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            input.next();
        }
        return input.nextInt();
    }

    private int inputDigit() {
        gameView.printMessage(GameView.INPUT_DIGIT);
        while (!input.hasNextInt()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            input.next();
        }
        return input.nextInt();
    }
}
