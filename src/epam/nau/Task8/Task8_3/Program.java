package epam.nau.Task8.Task8_3;

import epam.nau.Task8.Task8_2.StringsMeter;

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
