package ua.univer.Task8.Task8_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Task8_3.txt"));
        String text = scanner.nextLine();

        StringsProcessing processing = new StringsProcessing();
        processing.getResult(text);
    }
}
