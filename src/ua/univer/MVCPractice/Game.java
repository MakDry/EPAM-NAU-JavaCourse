package ua.univer.MVCPractice;

public class Game extends User {
    private int randMin;
    private int randMax;
    private int trueDigit;

    public Game(String playerName, int min, int max) {
        super(playerName);
        setTrueDigit(min, max);
        this.randMax = max;
        this.randMin = min;
    }

    public Game() {
        super("Default");
        setTrueDigit(0, 100);
        this.randMax = 100;
        this.randMin = 0;
    }

    private void setTrueDigit(int min, int max) {
        this.trueDigit = (int) ((Math.random() * (max - min)) + min);
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

    public int getTrueDigit() {
        return trueDigit;
    }


}
