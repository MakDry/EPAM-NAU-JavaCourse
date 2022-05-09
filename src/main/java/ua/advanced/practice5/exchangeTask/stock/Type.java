package ua.advanced.practice5.exchangeTask.stock;

public enum Type {
    BUY(0), SELL(1);

    private int value;

    Type(int value) {
        this.value = value;
    }
}
