package ua.advanced.practice7.Entities;

public class Movie {
    private String name;
    private String[] actorsNames;
    private String releaseDate;
    private String releaseCountry;

    public Movie(String name, String[] actorsNames, String releaseDate, String releaseCountry) {
        this.name = name;
        this.actorsNames = actorsNames;
        this.releaseDate = releaseDate;
        this.releaseCountry = releaseCountry;
    }

    public Movie() {
        name = "Unnamed";
        actorsNames = new String[]{"Empty"};
        releaseDate = "00.00.2022";
        releaseCountry = "Non country";
    }
}
