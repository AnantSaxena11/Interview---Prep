package Matrix;
public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);
        // Assign values to m1
        m1.matrix[0][0] = 1;
        m1.matrix[0][1] = 2;
        m1.matrix[1][0] = 3;
        m1.matrix[1][1] = 4;

        // Assign values to m2
        m2.matrix[0][0] = 5;
        m2.matrix[0][1] = 6;
        m2.matrix[1][0] = 7;
        m2.matrix[1][1] = 8;

        // Perform matrix addition
        Matrix result = m1.addMatrix(m2);

        // Prevent NullPointerException
        if (result != null) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(result.matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
