package ua.advanced.practice5.airportTask.plane;

import ua.advanced.practice5.airportTask.plane.types.Capacity;
import ua.advanced.practice5.airportTask.plane.types.Range;

public class Plane {
    private Capacity capacity;
    private Range range;
    private int passengers;

    public Plane(Capacity capacity, Range range) {
        this.capacity = capacity;
        this.range = range;
    }

    public void addPassengers(int passengers) {
        this.passengers += passengers;
    }

    public void takePassengers(int passengers) {
        this.passengers -= passengers;
    }

    public boolean passengersCheck() {
        return passengers < capacity.getValue();
    }

    public int getPassengers() {
        return passengers;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public Range getRange() {
        return range;
    }
}
