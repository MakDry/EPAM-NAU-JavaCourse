package ua.advanced.practice7.Entities;

import java.util.List;

public class Movie {
    private String title;
    private List<Person> actors;
    private String dateOfCreation;
    private String country;

    public Movie(String title, List<Person> actors, String dateOfCreation, String country) {
        this.title = title;
        this.actors = actors;
        this.dateOfCreation = dateOfCreation;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String day, String month, String year) {
        this.dateOfCreation = year.concat("-" + month + "-" + day);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
