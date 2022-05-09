package ua.advanced.practice2.entity;

import java.beans.XMLDecoder;
import java.io.*;

public class XMLDeserialization {
    private static final String FILE_PATH = "practice2.xml";

    public static City[] deserializeFromXml() {
        City[] cities = new City[10];
        try (XMLDecoder in = new XMLDecoder(new ObjectInputStream(new FileInputStream(FILE_PATH)))) {
            cities = (City[]) in.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }
}
