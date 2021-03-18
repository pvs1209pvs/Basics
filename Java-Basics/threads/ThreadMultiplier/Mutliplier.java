public class Mutliplier implements Runnable {

    Matrix a, b, result;
    int startingRow, endingRow;

    Mutliplier(Matrix a, Matrix b, Matrix result, int startingRow, int endingRow) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.startingRow = startingRow;
        this.endingRow = endingRow;
    }

    @Override
    public void run() {

        double runningTotal = 0;

        for (int i = startingRow; i < endingRow; i++) {
            for (int j = 0; j < Main.n; j++) {
                for (int k = 0; k < Main.n; k++) {
                    runningTotal +=  a.getFrom(i, k)* b.getFrom(k, j);
                }
                result.setAt(i, j, runningTotal);
                runningTotal  = 0;
            }
        }

    }

}