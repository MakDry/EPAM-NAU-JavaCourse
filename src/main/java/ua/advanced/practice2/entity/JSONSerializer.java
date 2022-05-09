package ua.advanced.practice2.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.advanced.practice1.task2.Container;

import java.io.*;

public class JSONSerializer {
    public static void serializeToJson(Container cities, String FILE_PATH){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FILE_PATH), cities);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
