package epam.nau.Task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("userText.txt"));
        String text = scan.nextLine();
        StringProcessing processing = new StringProcessing(text);

         processing.processing();
    }
}
