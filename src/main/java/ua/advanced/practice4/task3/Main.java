package ua.advanced.practice4.task3;

public class Main {
    private static final Part3 NON_SYNCHRONIZED_CONTROLLER;
    private static final Part3 SYNCHRONIZED_CONTROLLER;

    static {
        NON_SYNCHRONIZED_CONTROLLER = new Part3();
        SYNCHRONIZED_CONTROLLER = new Part3();
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println(">>>Not synchronized threads: ");
        new Thread(new NonSynchronizedThread(NON_SYNCHRONIZED_CONTROLLER)).start();
        new Thread(new NonSynchronizedThread(NON_SYNCHRONIZED_CONTROLLER)).start();
        new Thread(new NonSynchronizedThread(NON_SYNCHRONIZED_CONTROLLER)).start();

        Thread.sleep(1000);
        System.out.println("\n==================================");
        System.out.println("\n>>>Synchronized threads: ");
        new Thread(new SynchronizedThread(SYNCHRONIZED_CONTROLLER)).start();
        new Thread(new SynchronizedThread(SYNCHRONIZED_CONTROLLER)).start();
        new Thread(new SynchronizedThread(SYNCHRONIZED_CONTROLLER)).start();
    }
}
