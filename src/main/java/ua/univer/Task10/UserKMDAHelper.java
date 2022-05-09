package ua.univer.Task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserKMDAHelper {
    private String[] urls;
    private String[] months;

    public UserKMDAHelper() {
        urls = new String[3];
        months = new String[3];
        months[0] = "January";
        months[1] = "February";
        months[2] = "March";
        urls[0] = "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/d2b1a7d2-9222-4dfa-b57e-c0bb0b21485b/download/sichen-zp-2019.csv";
        urls[1] = "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/38ef4e5e-72ec-4715-95d7-28c0fd42176c/download/liutii-zp-2019.csv";
        urls[2] = "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/953aae94-8c82-4296-881f-f57b3a7be389/download/berezen-2019.csv";
    }

    public double maxSalary(List<User> users) {
        double maxSalary = 0.0;
        for (var user : users) {
            if (maxSalary < user.getSalary())
                maxSalary = user.getSalary();
        }
        return maxSalary;
    }

    public List<User> minSalary(List<User> users) {
        List<User> minSalaryUsers = new ArrayList<>();
        User minSalaryUser = users.get(0);
        for (var user : users) {
            if (minSalaryUser.getSalary() > user.getSalary())
                minSalaryUser = user;
        }
        for (var user : users) {
            if (minSalaryUser.getSalary() == user.getSalary())
                minSalaryUsers.add(user);
        }
        return minSalaryUsers;
    }


    public List<User> averageSalary(List<User> users) {
        List<User> averageSalaryUsers = new ArrayList<>();
        double salarySum = 0.0;
        double usersCounter = 0.0;
        for (var user : users) {
            salarySum += user.getSalary();
            usersCounter++;
        }
        double averageSalary = salarySum / usersCounter;
        for (var user : users) {
            if (user.getSalary() > (averageSalary - (averageSalary / 100 * 20)) & user.getSalary() < (averageSalary + (averageSalary / 100 * 20))) {
                averageSalaryUsers.add(user);
            }
        }
        return averageSalaryUsers;
    }

    public String biggestSalary() {
        double[] data = averageSalaryPerMonth();
        String month = "";
        double biggestSalary = 0.0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > biggestSalary) {
                month = months[i];
                biggestSalary = data[i];
            }
        }
        return month + " - " + biggestSalary;
    }

    public double[] averageSalaryPerMonth() {
        double[] averageSalaryPerMonth = new double[urls.length];
        int monthCounter = 0;
        while (monthCounter < urls.length) {
            double salarySum = 0.0;
            double userCounter = 0.0;
            for (var user : getUserFromMonth(monthCounter)) {
                salarySum += user.getSalary();
                userCounter++;
            }
            double averageSalary = salarySum / userCounter;
            averageSalaryPerMonth[monthCounter] = averageSalary;
            monthCounter++;
        }
        return averageSalaryPerMonth;
    }

    private List<User> getUserFromMonth(int monthIndex) {
        List<User> users = new ArrayList<>();
        try {
            URL website = new URL(urls[monthIndex]);
            URLConnection connection = website.openConnection();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                br.readLine();
                while (br.ready()) {
                    String data = br.readLine();
                    String[] words = data.split(";");
                    users.add(new User(words[0], words[1],
                            Double.parseDouble(words[2].replace(',', '.').replace('₴', ' ').replace(" ", ""))));
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return users;
    }

    public List<User> getUserFromURL() {
        List<User> users = new ArrayList<>();
        try {
            for (int i = 0; i < urls.length; i++) {
                URL website = new URL(urls[i]);
                URLConnection connection = website.openConnection();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    br.readLine();
                    while (br.ready()) {
                        String data = br.readLine();
                        String[] words = data.split(";");
                        users.add(new User(words[0], words[1],
                                Double.parseDouble(words[2].replace(',', '.').replace('₴', ' ').replace(" ", ""))));
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return users;
    }

    public String[] getMonths() {
        return months;
    }
}
