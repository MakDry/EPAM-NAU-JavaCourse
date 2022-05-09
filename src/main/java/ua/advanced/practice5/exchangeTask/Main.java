package ua.advanced.practice5.exchangeTask;

import ua.advanced.practice5.exchangeTask.functions.Broker;
import ua.advanced.practice5.exchangeTask.functions.StockGenerator;
import ua.advanced.practice5.exchangeTask.stock.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Exchange exchange = new Exchange();

        StockGenerator stockGenerator = new StockGenerator(exchange, 15);

        Broker broker1 = new Broker(exchange, Type.SELL);
        Broker broker2 = new Broker(exchange, Type.BUY);
        Broker broker3 = new Broker(exchange, Type.SELL);
        Broker broker4 = new Broker(exchange, Type.BUY);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.execute(stockGenerator);
        executor.execute(broker1);
        executor.execute(broker2);
        executor.execute(broker3);
        executor.execute(broker4);
    }
}
