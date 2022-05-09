package ua.advanced.practice4.task1;

public class ThreadClass extends Thread {

    public ThreadClass(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            while (counter < 6) {
                Thread.sleep(333);
                System.out.println(getName());
                counter++;
            }
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
}
