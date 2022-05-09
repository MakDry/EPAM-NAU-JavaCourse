package ua.advanced.practice5.auctionTask.entitiesGenerators;

import ua.advanced.practice5.auctionTask.entities.Auctioneer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class AuctioneersGenerator {
    private List<Auctioneer> auctioneers;
    private static CountDownLatch countDown;

    public AuctioneersGenerator(List<Auctioneer> auctioneers, int numberOfAuctioneers, CountDownLatch countDown) {
        this.auctioneers = auctioneers;
        this.countDown = countDown;
        generateAuctioneers(numberOfAuctioneers);
    }

    private void generateAuctioneers(int numberOfAuctioneers) {
        for (int i = 0; i < numberOfAuctioneers; i++) {
            auctioneers.add(new Auctioneer((new Random().nextInt(100) + 1) * 10_000, i, countDown));
        }
    }
}
