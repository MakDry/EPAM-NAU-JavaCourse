package ua.univer.Task9;

class MatrixException extends Exception {
    public MatrixException(String message) {
        super(message);
    }
}

public class Matrix {

    private double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns) {
        this.matrix = new double[rows][columns];
    }

    public double[][] matricesMultiplication(Matrix obj) {
        checkMatrix(obj);
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j] * obj.getIndexValue(i, j);
            }
        }
        return newMatrix;
    }

    public double[][] matricesAddition(Matrix obj) {
        checkMatrix(obj);
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j] + obj.getIndexValue(i, j);
            }
        }
        return newMatrix;
    }

    public double[][] matricesDeduction(Matrix obj) {
        checkMatrix(obj);
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j] - obj.getIndexValue(i, j);
            }
        }
        return newMatrix;
    }

    public void setIndexValue(int row, int column, double value) {
        matrix[row][column] = value;
    }

    public double getIndexValue(int row, int column) {
        return matrix[row][column];
    }

    public double[][] getArray() {
        return matrix;
    }

    public int getRows() {
        return matrix.length;
    }

    public int getColumns() {
        return matrix[0].length;
    }

    public void checkMatrix(Matrix obj) {
        try {
            if (obj.getArray().length != matrix.length || obj.getArray()[0].length != matrix[0].length) {
                throw new MatrixException("Different sizes of matrices");
            }
        } catch (MatrixException e) {
            e.getMessage();
        }
    }
}
