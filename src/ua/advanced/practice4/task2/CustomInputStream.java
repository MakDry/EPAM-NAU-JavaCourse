package ua.advanced.practice4.task2;

import java.io.IOException;
import java.io.InputStream;

public class CustomInputStream extends InputStream {
    @Override
    public int read() throws IOException {
        int symbol = System.in.read();
        if (symbol == '\n'){
            return -1;
        } else {
            return symbol;
        }
    }
}
