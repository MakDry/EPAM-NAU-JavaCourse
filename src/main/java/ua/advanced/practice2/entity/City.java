package ua.advanced.practice2.entity;

public class City {
    private String name;
    private int residents;
    private int code;
    private boolean isCapital;

    public City(String name, int residents, int code, boolean isCapital){
        this.name = name;
        this.residents = residents;
        this.code = code;
        this.isCapital = isCapital;
    }

    public City(){
        this("Default", 0, 000000, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResidents() {
        return residents;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "\n\t" + name +
                "\n1. Number of residents: " + residents +
                "\n2. Code: " + code +
                "\n3. Is capital: " + isCapital;
    }
}
