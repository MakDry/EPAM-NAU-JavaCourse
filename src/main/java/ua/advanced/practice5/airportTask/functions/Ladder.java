package ua.advanced.practice5.airportTask.functions;

import ua.advanced.practice5.airportTask.Sky;
import ua.advanced.practice5.airportTask.plane.Plane;
import ua.advanced.practice5.airportTask.plane.types.Range;

public class Ladder implements Runnable {
    private Sky sky;
    private Range range;

    public Ladder(Sky sky, Range range) {
        this.sky = sky;
        this.range = range;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Ladder " + range);

                //Time to unload passengers
                Thread.sleep(500);
                Plane plane = sky.get(range);
                if (plane != null) {
                    while (plane.getPassengers() > 0) {
                        Thread.sleep(100);
                        plane.takePassengers(50);
                        System.out.println(plane.getPassengers() + " Unloaded plane. " + Thread.currentThread().getName());
                    }
                    sky.add(plane);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
