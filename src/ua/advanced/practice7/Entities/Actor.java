package ua.advanced.practice7.Entities;

public class Actor {
    private String firstName;
    private String surname;
    private String patronymic;
    private String datedOfBirth;
    private boolean isDirector;

    public Actor(String firstName, String surname, String patronymic, String datedOfBirth, boolean isDirector) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.datedOfBirth = datedOfBirth;
        this.isDirector = isDirector;
    }

    public Actor() {
        firstName = "Non name";
        surname = "Non surname";
        patronymic = "Non patronymic";
        datedOfBirth = "00.00.2022";
        isDirector = false;
    }
}
