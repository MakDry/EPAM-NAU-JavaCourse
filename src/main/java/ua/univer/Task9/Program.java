package ua.univer.Task9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}

public class Program {
    public static final BufferedReader br;
    public static final Logger logger;

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        logger = Logger.getLogger(Program.class.getName());

    }

    public static void main(String[] args) {
        logger.log(Level.INFO, ">Enter the number of rows in the matrix: ");
        int rows = getValueInt();
        logger.log(Level.INFO, ">Enter the number of columns in the matrix: ");
        int columns = getValueInt();
        logger.log(Level.INFO, ">Do you want to fill the matrix? \nP.S. print number of option\n1. Yes\n2. No");
        int option = checkOptionValue();

        Matrix firstMatrix = new Matrix(0, 0);
        switch (option) {
            case 1: {
                double[][] userMatrix = new double[rows][columns];
                for (int i = 0; i < userMatrix.length; i++) {
                    for (int j = 0; j < userMatrix[i].length; j++) {
                        logger.log(Level.INFO, "Print Matrix [" + i + "][" + j + "] value: ");
                        userMatrix[i][j] = getValueDouble();
                    }
                }
                firstMatrix = new Matrix(userMatrix);
                logger.log(Level.INFO, "<Matrix was created>");
                break;
            }

            case 2: {
                firstMatrix = new Matrix(rows, columns);
                logger.log(Level.INFO, "<Matrix was created>");
                break;
            }
        }
        int numberOfRow = checkMatrixRowBorders(firstMatrix);
        int numberOfColumn = checkMatrixColumnBorders(firstMatrix);
        logger.log(Level.INFO, ">Input value for Matrix[" + numberOfRow + "][" + numberOfColumn + "] value: ");
        double setNewValue = getValueDouble();
        firstMatrix.setIndexValue(numberOfRow, numberOfColumn, setNewValue);

        logger.log(Level.INFO, "Fill another one matrix to multiply, add and subtract them");
        Matrix secondMatrix = new Matrix(0, 0);
        double[][] additionalMatrix = new double[rows][columns];
        for (int i = 0; i < additionalMatrix.length; i++) {
            for (int j = 0; j < additionalMatrix[i].length; j++) {
                logger.log(Level.INFO, "Print Matrix [" + i + "][" + j + "] value: ");
                additionalMatrix[i][j] = getValueDouble();
            }
        }
        secondMatrix = new Matrix(additionalMatrix);
        logger.log(Level.INFO, "1. Matrix #1 info:\n>Number of rows: " + firstMatrix.getRows() + "\n>Number  of columns: " + firstMatrix.getColumns());
        logger.log(Level.INFO, "2. Matrix #2 info:\n>Number of rows: " + secondMatrix.getRows() + "\n>Number  of columns: " + secondMatrix.getColumns());
        double[][] tempArray = firstMatrix.matricesAddition(secondMatrix);
        logger.log(Level.INFO, "\n>The result of adding, subtraction and multiplication matrices: ");
        printArray(firstMatrix.matricesAddition(secondMatrix));
        printArray(firstMatrix.matricesDeduction(secondMatrix));
        printArray(firstMatrix.matricesMultiplication(secondMatrix));

        // Написати взаємодію з користувачем при видаленні по індексу, заміні числа по індексу. Покрити тестами
    }

    private static void printArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println("},");
        }
        System.out.print("\n");
    }

    private static int checkMatrixRowBorders(Matrix matrix) {
        while (true) {
            try {
                logger.log(Level.INFO, " 1. Number of element's row which you wanna change:");
                int value = getValueInt();
                if (value < 0 || value > matrix.getRows() - 1) {
                    throw new InputException("Out of matrix borders value");
                }
                return value;
            } catch (InputException e) {
                logger.log(Level.SEVERE, "" + e.getMessage());
            }
        }
    }

    private static int checkMatrixColumnBorders(Matrix matrix) {
        while (true) {
            try {
                logger.log(Level.INFO, "2. Number of element's column which you wanna change:");
                int value = getValueInt();
                if (value < 0 || value > matrix.getColumns() - 1) {
                    throw new InputException("Out of matrix borders value");
                }
                return value;
            } catch (InputException e) {
                logger.log(Level.SEVERE, "" + e.getMessage());
            }
        }
    }

    private static int checkOptionValue() {
        while (true) {
            try {
                int value = getValueInt();
                if (value < 1 || value > 2) {
                    throw new InputException("Not option value");
                }
                return value;
            } catch (InputException e) {
                logger.log(Level.SEVERE, "" + e.getMessage());
            }
        }
    }

    private static double getValueDouble() {
        while (true) {
            try {
                String value = br.readLine();
                return Double.parseDouble(value);
            } catch (InputMismatchException | IOException | NumberFormatException e) {
                logger.log(Level.SEVERE, "Not double value");
            }
        }
    }

    private static int getValueInt() {
        while (true) {
            try {
                String value = br.readLine();
                return Integer.parseInt(value);
            } catch (InputMismatchException | IOException | NumberFormatException e) {
                logger.log(Level.SEVERE, "Not int value");
            }
        }
    }
}




