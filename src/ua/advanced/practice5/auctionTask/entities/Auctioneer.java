package ua.advanced.practice5.auctionTask.entities;

import java.util.concurrent.CountDownLatch;

public class Auctioneer implements Runnable{
    private int capital;
    private int queueNumber;
    private static CountDownLatch countDown;
    private boolean skipNextLot = false;

    public Auctioneer (int capital, int queueNumber, CountDownLatch countDown) {
        this.capital = capital;
        this.queueNumber = queueNumber;
        this.countDown = countDown;
    }

    @Override
    public void run() {
        try {
            System.out.println("> Auctioneer with number " + queueNumber + " connected to auction with bet: " +
                capital + "$");
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCapital() {
        return capital;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setSkipNextLot(boolean skipNextLot) {
        this.skipNextLot = skipNextLot;
    }

    public boolean isSkipNextLot() {
        return skipNextLot;
    }
}
