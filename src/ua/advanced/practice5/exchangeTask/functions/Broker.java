package ua.advanced.practice5.exchangeTask.functions;

import ua.advanced.practice5.exchangeTask.Exchange;
import ua.advanced.practice5.exchangeTask.stock.Stock;
import ua.advanced.practice5.exchangeTask.stock.Type;

public class Broker implements Runnable {
    private Exchange exchange;
    private Type stockType;

    public Broker(Exchange exchange, Type stockType) {
        this.exchange = exchange;
        this.stockType = stockType;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.currentThread().setName("Seller " + stockType);

                Thread.sleep(1500);
                Stock stock = exchange.get(stockType);
                if (stock != null) {
                    stock.setCost(stock.getCost() * exchange.getIndex());
                    exchange.add(stock);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
