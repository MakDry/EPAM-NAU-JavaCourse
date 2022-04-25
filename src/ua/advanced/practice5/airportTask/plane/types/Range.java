package ua.advanced.practice5.airportTask.plane.types;

public enum Range {
    SHORT(1000), MEDIUM(5000), LONG(10_000);

    private int value;

    Range (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
