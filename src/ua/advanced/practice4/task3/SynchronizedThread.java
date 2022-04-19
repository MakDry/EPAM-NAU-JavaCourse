package ua.advanced.practice4.task3;

public class SynchronizedThread implements Runnable {
    private final Part3 controller;

    public SynchronizedThread(Part3 controller) {
        this.controller = controller;
    }

    public void compare() {
        System.out.println(">Synchronized thread compare: " + (controller.getCounter() == controller.getCounter2()));
    }

    @Override
    public void run() {
        synchronized (controller) {
            for (int i = 0; i < 5; i++) {
                compare();
                controller.setCounter(controller.getCounter() + 1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                controller.setCounter2(controller.getCounter2() + 1);
            }
        }
    }
}
