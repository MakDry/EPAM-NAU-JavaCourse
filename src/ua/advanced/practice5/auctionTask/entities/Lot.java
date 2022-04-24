package ua.advanced.practice5.auctionTask.entities;

public class Lot {
    private int lotPrice;
    private int lotNumber;

    public Lot (int lotPrice, int lotNumber) {
        this.lotPrice = lotPrice;
        this.lotNumber = lotNumber;
    }

    public synchronized void raiseBet(int newLotPrice) {
        lotPrice = newLotPrice;
    }

    public int getLotPrice() {
        return lotPrice;
    }

    public int getLotNumber() {
        return lotNumber;
    }
}
