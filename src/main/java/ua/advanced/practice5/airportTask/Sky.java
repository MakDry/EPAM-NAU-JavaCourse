package ua.advanced.practice5.airportTask;

import ua.advanced.practice5.airportTask.plane.Plane;
import ua.advanced.practice5.airportTask.plane.types.Capacity;
import ua.advanced.practice5.airportTask.plane.types.Range;

import java.util.ArrayList;
import java.util.List;

public class Sky {
    private List<Plane> planes;
    private int planesCounter = 0;

    public Sky() {
        planes = new ArrayList<>();
    }

    public synchronized void add(Plane plane) {
        notifyAll();
        planes.add(plane);
        System.out.println("> The plane took off");
        planesCounter++;
    }

    public synchronized Plane get(Range range) {
        try {
            if (planesCounter > 0) {
                notifyAll();
                for (Plane plane : planes) {
                    if (plane.getRange() == range) {
                        planesCounter--;
                        System.out.println("> The plane has landed");
                        planes.remove(plane);
                        return plane;
                    }
                }
            }

            System.out.println("> There are no planes ready to land");
            wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Plane get(Capacity capacity) {
        try {
            if (planesCounter > 0) {
                notifyAll();
                for (Plane plane : planes) {
                    if (plane.getCapacity() == capacity) {
                        planesCounter--;
                        System.out.println("> The plane has landed");
                        planes.remove(plane);
                        return plane;
                    }
                }
            }

            System.out.println("> There are no planes ready to land");
            wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
}
