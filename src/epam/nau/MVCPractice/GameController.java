package epam.nau.MVCPractice;

import java.util.Scanner;

public class GameController {
    private Game game;
    private GameView gameView = new GameView();
    private Scanner input = new Scanner(System.in);

    public GameController(String playerName, int min, int max) {
        game = new Game(playerName, min, max);
    }

    public void gamePlay(int digit) {
        int temp = 0;
        while (digit != game.getTrueDigit()) {
            gameView.viewGameDetails(game.getRollNum(), game.getRandMin(), game.getRandMax());
            digit = input.nextInt();
            if (digit > game.getTrueDigit() && digit < game.getRandMax()) {
                game.setRandMax(digit);
            } else if (digit < game.getTrueDigit() && digit > game.getRandMin()) {
                game.setRandMin(digit);
            }
            temp++;
            game.setRollNum(temp);
        }
        gameView.viewGameResult(game.getPlayerName(), game.getRollNum());
    }
}
