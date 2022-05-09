package ua.advanced.practice4.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        ThreadClass thread1 = new ThreadClass("Thread-1");
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new RunnableClass());
        thread2.start();
    }
}
