package epam.nau.MVCPractice;

public class Game {
    private int randMin;
    private int randMax;
    private int trueDigit;
    private String playerName;
    private int rollNum;

    public Game(String playerName, int min, int max) {
        this.playerName = playerName;
        this.rollNum = 0;
        setTrueDigit(min, max);
        this.randMax = max;
        this.randMin = min;
    }

    public Game() {
        this.playerName = "Default";
        this.rollNum = 0;
        setTrueDigit(0, 100);
        this.randMax = 100;
        this.randMin = 0;
    }

    private void setTrueDigit(int min, int max) {
        this.trueDigit = (int) ((Math.random() * (max - min)) + min);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRandMax() {
        return randMax;
    }

    public void setRandMax(int randMax) {
        this.randMax = randMax;
    }

    public int getRandMin() {
        return randMin;
    }

    public void setRandMin(int randMin) {
        this.randMin = randMin;
    }

    public int getRollNum() {
        return rollNum;
    }

    public int getTrueDigit() {
        return trueDigit;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }
}
