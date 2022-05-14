package ua.advanced.practice7_8.model;

import java.sql.Date;

public class Person implements Entity {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;

    public Person(int id, String name, String surname, String patronymic, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
