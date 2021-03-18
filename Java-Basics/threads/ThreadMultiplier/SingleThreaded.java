class SingleThreaded{

    Matrix multiply(Matrix a, Matrix b){

        Matrix result = new Matrix(Main.n, Main.n);

        double runningTotal = 0;
        for (int i = 0; i < Main.n; i++) {
            for (int j = 0; j < Main.n; j++) {
                for (int k = 0; k < Main.n; k++) {
                    runningTotal += a.getFrom(i, k) * b.getFrom(k, j);
                }
                result.setAt(i, j, runningTotal);
                runningTotal = 0;
            }
        }

        return result;
        
    }
    
}