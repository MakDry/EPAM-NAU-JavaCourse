package ua.advanced.practice5.exchangeTask.functions;

import ua.advanced.practice5.exchangeTask.Exchange;
import ua.advanced.practice5.exchangeTask.stock.Stock;
import ua.advanced.practice5.exchangeTask.stock.Type;

import java.util.Random;

public class StockGenerator implements Runnable {
    private Exchange exchange;
    private int stockCount;

    public StockGenerator(Exchange exchange, int stockCount) {
        this.exchange = exchange;
        this.stockCount = stockCount;
    }

    @Override
    public void run() {
        int counter = 0;
        while(counter < stockCount) {
            Thread.currentThread().setName("Stock Generator");
            counter++;
            exchange.add(new Stock(getRandomCost(), getRandomType()));
            exchange.setIndex(exchange.getIndex() + 0.1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private double getRandomCost() {
        return (new Random().nextDouble() * 1000) * exchange.getIndex();
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }
}
