import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThreaded {

    Matrix multiply(Matrix a, Matrix b){

        Matrix result = new Matrix(Main.n, Main.n);

        ExecutorService service = Executors.newFixedThreadPool(Main.NUM_PROCESSORS);

            for (int i = 0; i < Main.NUM_PROCESSORS; i++) {
                service.execute(new Mutliplier(a, b, result, (Main.n/Main.NUM_PROCESSORS)*i, (Main.n/Main.NUM_PROCESSORS)*(i+1)));
            }

            service.shutdown();
            while (!service.isTerminated()) {}

        return result;

    }
}