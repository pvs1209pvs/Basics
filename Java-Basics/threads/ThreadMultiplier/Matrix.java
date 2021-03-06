import java.util.List;

public class Matrix {

    private final double[][] matrix;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        matrix = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }


    public void fillRow(int i, List<Double> numbers) {
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = numbers.get(j);
        }
    }

    double[] getRow(int i) {
        return matrix[i];
    }

    double[] getCol(int j){
        double[] col = new double[this.cols];

        for (int i = 0; i < rows; i++) {
            col[i] = matrix[i][j];
        }

        return col;
    }

    void setAt(int i, int j, double v) {
        matrix[i][j] = v;
    }

    double getFrom(int i, int j) {
        return matrix[i][j];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getMatrix() {
        return matrix;
    }

     void deepCopy(Matrix from) {

        for (int i = 0; i < from.getRows(); i++) {
            for (int j = 0; j < from.getCols(); j++) {
                setAt(i, j, from.getFrom(i, j));
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                stringBuilder.append(aDouble).append("    ");
            }
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();

    }

}
