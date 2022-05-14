package ua.advanced.practice7_8.controller;

import ua.advanced.practice7_8.jdbc.connections.ConnectionSetter;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws SQLException {
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = "2020-10-21";
        String newDate2 = "2019-10-21";
        try {
            date = sdf.parse(newDate);
            Date secondDate = sdf.parse(newDate2);
            int year = new Date().getYear() + 1900;
            System.out.println(year);
            System.out.println(new Date("2020-10-21"));
            System.out.println(date.equals(secondDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ConnectionSetter.closeConnections();
    }
}
