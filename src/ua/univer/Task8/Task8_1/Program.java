package ua.univer.Task8.Task8_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Task8_1.txt"));
        String text = scan.nextLine();
        StringsMatcher processing = new StringsMatcher(text);
        processing.processing();
    }
}
