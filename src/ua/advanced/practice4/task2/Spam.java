package ua.advanced.practice4.task2;

public class Spam {
    private Thread[] threads;
    private String[] messages;
    private int[] intervals;

    public Spam(String[] messages, int[] intervals, int threadsNumber) {
        this.messages = messages;
        this.intervals = intervals;
        threads = new Thread[threadsNumber];
    }

    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(messages[i], intervals[i]);
            threads[i].start();
        }
    }

    public void stop() {
        for (Thread thread : threads) {
            thread.stop();
        }
    }

    private static class Worker extends Thread {
        private String message;
        private int interval;

        public Worker(String message, int interval) {
            this.message = message;
            this.interval = interval;
        }

        @Override
        public void run() {
            long startedAt = System.currentTimeMillis();

            while (true) {
                if (interval < (System.currentTimeMillis() - startedAt))
                    break;
                System.out.println(message);
            }
        }
    }
}