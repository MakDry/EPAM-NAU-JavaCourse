package ua.advanced.practice5.airportTask.plane.types;

public enum Capacity {
    SMALL(100), MEDIUM(500), BIG(1000);

    private int value;

    Capacity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
