package epam.nau.Task9.test;

import epam.nau.Task9.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMatrix {
    Matrix matrix1;
    Matrix matrix2;
    Matrix matrix3;
    double[][] array1 = {{1, 2, 3, 4,}, {4, 3, 2, 1,}, {-5, -10, 100, 200}};
    double[][] array2 = {{200, 100, -10, -5}, {1, 2, 3, 4,}, {4, 3, 2, 1,}};
    double[][] array3 = {{0, 0, 0, 0, 0, 0,}, {0}};

    @BeforeEach
    void setUpTest() {
        matrix1 = new Matrix(array1);
        matrix2 = new Matrix(array2);
        matrix3 = new Matrix(array3);
    }

    @Test
    void testMatricesMultiplication() {
        double[][] temp = matrix1.matricesMultiplication(matrix2);
        Assertions.assertEquals(720, matrixValueAdder(temp));
    }

    @Test
    void testMatricesAddition() {
        double[][] temp = matrix1.matricesAddition(matrix2);
        Assertions.assertEquals(610, matrixValueAdder(temp));
    }

    @Test
    void testMatricesDeduction() {
        double[][] temp = matrix1.matricesDeduction(matrix2);
        Assertions.assertEquals(0, matrixValueAdder(temp));
    }

    private double matrixValueAdder(double[][] array) {
        double value = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                value += array[i][j];
            }
        }
        return value;
    }
}
