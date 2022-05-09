package ua.advanced.practice4.task1;

public class RunnableClass implements Runnable {

    @Override
    public void run() {
        int counter = 0;
        try {
            while (counter < 6){
                Thread.sleep(333);
                System.out.println(Thread.currentThread().getName());
                counter++;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
