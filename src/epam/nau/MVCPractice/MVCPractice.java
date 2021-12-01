package epam.nau.MVCPractice;

public class MVCPractice {
    public static void main(String[] args) {
        Game game = new Game();
        GameView gameView = new GameView();

        GameController controller = new GameController(game, gameView);
        controller.gameProcessing();
    }
}
