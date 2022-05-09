package ua.advanced.practice5.airportTask.functions;

import ua.advanced.practice5.airportTask.Sky;
import ua.advanced.practice5.airportTask.plane.Plane;
import ua.advanced.practice5.airportTask.plane.types.Capacity;

public class Terminal implements Runnable{
    private Sky sky;
    private Capacity capacity;

    public Terminal(Sky sky, Capacity capacity) {
        this.sky = sky;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Terminal " + capacity);

                //Loading passengers
                Thread.sleep(500);
                Plane plane = sky.get(capacity);
                if (plane != null) {
                    while (plane.passengersCheck()) {
                        Thread.sleep(100);
                        plane.addPassengers(50);
                        System.out.println(plane.getPassengers() + " Loaded plane. " + Thread.currentThread().getName());
                    }
                    sky.add(plane);
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
