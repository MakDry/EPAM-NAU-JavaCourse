package ua.advanced.practice7.Entities;

public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;

    public Person(String name, String surname, String patronymic, String dateOfBirth) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String day, String month, String year) {
        this.dateOfBirth = year.concat("-" + month + "-" + day);
    }
}
