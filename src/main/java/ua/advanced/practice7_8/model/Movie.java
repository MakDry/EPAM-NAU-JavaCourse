package ua.advanced.practice7_8.model;

import java.sql.Date;

public class Movie implements Entity {
    private int id;
    private String title;
    private Person director;
    private Date dateOfCreation;
    private String country;

    public Movie(int id, String title,Person director, Date dateOfCreation, String country) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.dateOfCreation = dateOfCreation;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    @Override
    public int setId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
