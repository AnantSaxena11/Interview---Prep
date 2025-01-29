package Matrix;

public class Matrix {
    private int row;
    private int col;
    public int[][] matrix;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
    }

    public Matrix addMatrix(Matrix m2) {
        if (this.row != m2.row || this.col != m2.col) {
            System.out.println("Matrix Addition is not possible");
            return null;
        } else {
            Matrix result = new Matrix(this.row, this.col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result.matrix[i][j] = this.matrix[i][j] + m2.matrix[i][j];
                }
            }
            return result;
        }
    }
}
