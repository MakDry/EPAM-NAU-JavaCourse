package ua.advanced.practice5.airportTask;

import ua.advanced.practice5.airportTask.functions.Ladder;
import ua.advanced.practice5.airportTask.functions.PlaneGenerator;
import ua.advanced.practice5.airportTask.functions.Terminal;
import ua.advanced.practice5.airportTask.plane.types.Capacity;
import ua.advanced.practice5.airportTask.plane.types.Range;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Sky sky = new Sky();

        PlaneGenerator planeGenerator = new PlaneGenerator(sky, 5);

        Terminal terminal1 = new Terminal(sky, Capacity.SMALL);
        Terminal terminal2 = new Terminal(sky, Capacity.MEDIUM);
        Terminal terminal3 = new Terminal(sky, Capacity.BIG);

        Ladder ladder1 = new Ladder(sky, Range.SHORT);
        Ladder ladder2 = new Ladder(sky, Range.MEDIUM);
        Ladder ladder3 = new Ladder(sky, Range.LONG);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executor.execute(planeGenerator);
        executor.execute(terminal1);
        executor.execute(terminal2);
        executor.execute(terminal3);
        executor.execute(ladder1);
        executor.execute(ladder2);
        executor.execute(ladder3);

        executor.shutdown();
    }
}
