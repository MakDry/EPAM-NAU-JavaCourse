package ua.advanced.practice4.task2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner input;
    private static CustomInputStream inputStream;
    private static Spam spam;

    static {
        input = new Scanner(System.in);
        inputStream = new CustomInputStream();
    }

    public static void main(String[] args) {
        userInput();
        new Thread(() -> {
            while (true) {
                try {
                    if (inputStream.read() == -1) {
                        spam.stop();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        spam.start();
    }

    private static void userInput() {
        System.out.println(">Enter the number of messages to add: ");
        int numberOfMessages = intChecker();

        String[] messages = new String[numberOfMessages];
        int[] intervals = new int[numberOfMessages];

        for (int i = 0; i < numberOfMessages; i++) {
            System.out.println("\n==Message № " + (i + 1) + "==");
            System.out.println(">Enter value: ");
            messages[i] = input.next();
            System.out.println(">Enter time interval: ");
            intervals[i] = intChecker();
        }
        spam = new Spam(messages, intervals, numberOfMessages);
    }

    private static int intChecker() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Input Error!\nTry again: ");
            }
        }
    }
}
