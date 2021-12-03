package epam.nau.Task8.Task8_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Task8_2.txt"));
        String text = scanner.nextLine();
        StringsMeter processing = new StringsMeter();
        processing.getResult(text);
    }
}
