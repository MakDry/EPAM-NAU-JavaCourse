package ua.advanced.practice5.auctionTask.entitiesGenerators;

import ua.advanced.practice5.auctionTask.entities.Lot;
import java.util.List;
import java.util.Random;

public class LotsGenerator {
    private List<Lot> lots;

    public LotsGenerator(List<Lot> lots, int numberOfLots) {
        this.lots = lots;
        generateLots(numberOfLots);
    }

    private void generateLots(int numberOfLots) {
        for (int i = 0; i < numberOfLots; i++) {
            lots.add(new Lot((new Random().nextInt(100) + 1) * 1000, i));
        }
    }
}
