package epam.nau.Task5;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double a) {
        this.sideA = a;
        this.sideB = 5;
    }

    public Rectangle() {
        this.sideA = 4;
        this.sideB = 3;
    }

    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return (sideA * 2) + (sideB * 2);
    }

    public boolean isSquare() {
        if (sideA == sideB) {
            return true;
        } else {
            return false;
        }
    }

    public void replaceSide(){
        double temp = sideA;
        sideA = sideB;
        sideB = temp;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }
}
