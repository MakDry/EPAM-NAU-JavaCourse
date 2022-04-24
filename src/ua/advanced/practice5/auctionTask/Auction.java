package ua.advanced.practice5.auctionTask;

import ua.advanced.practice5.auctionTask.entities.Auctioneer;
import ua.advanced.practice5.auctionTask.entities.Lot;
import ua.advanced.practice5.auctionTask.entitiesGenerators.AuctioneersGenerator;
import ua.advanced.practice5.auctionTask.entitiesGenerators.LotsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Auction {
    private static CountDownLatch countDown = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException{
        List<Auctioneer> auctioneers = new ArrayList<>();
        List<Lot> lots = new ArrayList<>();

        new LotsGenerator(lots, 10);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Lot lot : lots) {
            new AuctioneersGenerator(auctioneers, 5, countDown);
            System.out.println("\n>> Lot number " + lot.getLotNumber() + " started");
            System.out.println("> Starting lot price: " + lot.getLotPrice() + "$");

            while(countDown.getCount() > 0){
                for (Auctioneer auctioneer : auctioneers) {
                    boolean haveEnoughCapital = false;
                    if (auctioneer.getCapital() >= lot.getLotPrice() && !auctioneer.isSkipNextLot()) {
                        haveEnoughCapital = true;
                        auctioneer.setSkipNextLot(false);
                        lot.raiseBet(auctioneer.getCapital());
                    } else if (auctioneer.getCapital() >= lot.getLotPrice() && auctioneer.isSkipNextLot()){
                        auctioneer.setSkipNextLot(false);
                    } else {
                        auctioneer.setSkipNextLot(true);
                    }
                    if (haveEnoughCapital)
                        executor.execute(auctioneer);
                }
                countDown.countDown();
            }
            Thread.sleep(1000);
            countDown = new CountDownLatch(3);
            Auctioneer winner = null;
            for (Auctioneer auctioneer : auctioneers) {
                if (auctioneer.getCapital() == lot.getLotPrice()){
                    winner = auctioneer;
                }
            }
            if (winner == null){
                System.out.println("> No one has won a bid for this lot");
            } else {
                System.out.println("> Auctioneer number " + winner.getQueueNumber() + " won the auction with bet " + winner.getCapital());
            }
        }
    }
}
