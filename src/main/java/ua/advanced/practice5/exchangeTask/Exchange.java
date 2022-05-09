package ua.advanced.practice5.exchangeTask;

import ua.advanced.practice5.exchangeTask.stock.Stock;
import ua.advanced.practice5.exchangeTask.stock.Type;

import java.util.ArrayList;
import java.util.List;

public class Exchange {
    private List<Stock> stocks;
    private int stocksCounter = 0;
    private double index = 1.0;

    public Exchange() {
        this.stocks = new ArrayList<>();
    }

    public synchronized void add(Stock stock) {
        notifyAll();
        stocks.add(stock);
        System.out.println("\n> New stock on exchange! \n> Cost: +" + stock.getCost());
        stocksCounter++;
        index -= 0.1;
    }

    public synchronized Stock get(Type stockType) {
        try {

            if(index < 0.4) {
                System.out.println(">>> The exchange was temporarily closed!");
                index += 0.1;
                Thread.sleep(5000);
            }

            if (stocksCounter > 0) {
                notifyAll();
                for (Stock stock : stocks) {
                    if (stock.getType() == stockType) {
                        stocksCounter--;
                        index += 0.1;
                        System.out.println("\n> The stock was bought! \n> Cost: -" + stock.getCost());
                        stocks.remove(stock);
                        return stock;
                    }
                }
            }
            System.out.println("\n>> There are no stocks on exchange");
            wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }
}
