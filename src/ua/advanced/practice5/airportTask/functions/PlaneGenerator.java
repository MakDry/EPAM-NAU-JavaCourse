package ua.advanced.practice5.airportTask.functions;

import ua.advanced.practice5.airportTask.Sky;
import ua.advanced.practice5.airportTask.plane.Plane;
import ua.advanced.practice5.airportTask.plane.types.Capacity;
import ua.advanced.practice5.airportTask.plane.types.Range;

import java.util.Random;

public class PlaneGenerator implements Runnable {
    private Sky sky;
    private int planeCount;

    public PlaneGenerator(Sky sky, int planeCount) {
        this.sky = sky;
        this.planeCount = planeCount;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < planeCount) {
            Thread.currentThread().setName(">Plane Generator");
            counter++;
            sky.add(new Plane(getRandomCapacity(), getRandomRange()));
        }
    }

    private Range getRandomRange() {
        Random random = new Random();
        return Range.values()[random.nextInt(Range.values().length)];
    }

    private Capacity getRandomCapacity() {
        Random random = new Random();
        return Capacity.values()[random.nextInt(Capacity.values().length)];
    }
}
