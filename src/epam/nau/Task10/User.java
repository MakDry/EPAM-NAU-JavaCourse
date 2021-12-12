package epam.nau.Task10;

public class User {
    private String name;
    private String position;
    private double salary;

    public User(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public User() {
        this.name = "name";
        this.position = "position";
        this.salary = 0.0;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name = " + name + '\'' +
                ", Position = " + position + '\'' +
                ", Salary = " + salary + " ₴\n";
    }
}
