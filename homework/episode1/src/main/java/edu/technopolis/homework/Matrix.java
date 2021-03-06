package edu.technopolis.homework;

public class Matrix {
    private long[][] data;
    private int numberOfRows;
    private int numberOfCols;

    public Matrix(long[][] data) {
        this.numberOfRows = data.length;
        if (numberOfRows > 0) {
            this.numberOfCols = data[0].length;
        } else {
            this.numberOfCols = 0;
        }

        this.data = data.clone();
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfCols() {
        return numberOfCols;
    }

    public long elementAt(int row, int col) {
        if (row < numberOfRows && col < numberOfCols &&
                row >= 0 && col >= 0){
            return data[row][col];
        } else {
            throw new IndexOutOfBoundsException("No such row or column");
        }
    }

    public Matrix multiplyBy(Matrix secondMatrix) {
        if (numberOfCols != secondMatrix.getNumberOfRows()) {
            throw new IllegalArgumentException("Cannot multiply matrices with such dimensions");
        } else {
            long[][] result = new long[numberOfRows][secondMatrix.getNumberOfCols()];
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < secondMatrix.getNumberOfCols(); j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < numberOfCols; k++) {
                        result[i][j] += data[i][k] * secondMatrix.elementAt(k, j);
                    }
                }
            }

            return new Matrix(result);
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
