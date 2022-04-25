package ua.advanced.practice5.exchangeTask.stock;

public class Stock {
    private double cost;
    private Type type;

    public Stock(double cost, Type type) {
        this.cost = cost;
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public Type getType() {
        return type;
    }

    public void setCost(double indexedCost) {
        cost = indexedCost;
    }
}
