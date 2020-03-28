package jo.edu.htu.utils;

public class Matrix {
    int rows;
    int cols;
    int[][] matrix;

    public Matrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] == null) {
                throw new IllegalArgumentException
                        ("row " + row + " is null");
            }
            if (matrix[row].length != matrix[0].length) {
                throw new IllegalArgumentException("Inconsistent rows");
            }
            if (matrix[row].length > row) {
                throw new IllegalArgumentException("Inconsistent rows");
            }

        }


        int[][] myInt = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            myInt[i] = matrix[i].clone();
        
        this.matrix = myInt;
        rows = matrix.length;
        cols = matrix[0].length;

    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public int value(int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if (row > matrix.length - 1) {
                throw new IllegalArgumentException("invalid cell index: " + row + "," + col);
            }
            if (col > matrix[i].length - 1) {
                throw new IllegalArgumentException("invalid cell index: " + row + "," + col);
            }
        }
        return matrix[row][col];
    }

    public void forEach(ValueConsumer valueConsumer) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                valueConsumer.accept(row, col, value(row, col));
            }
        }
    }

    public interface ValueConsumer {
        void accept(int row, int col, int value);
    }
}
