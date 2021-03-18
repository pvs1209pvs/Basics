import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {

    private static final int RUNS = 1;
    static final int NUM_PROCESSORS = Runtime.getRuntime().availableProcessors();
    static int n = 5;
    private static long time = 0;
    
    private Main() {

        int oldN = n;
        n = ((n+NUM_PROCESSORS)/NUM_PROCESSORS)*NUM_PROCESSORS;

        Matrix a = new Matrix(n, n);
        Matrix b = new Matrix(n, n);

        for (int i = 0; i < n; i++) {

            StringBuilder equation = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if(i<oldN && j<oldN) equation.append("+" + (int) (Math.random() * 10+1) + "a");
                else equation.append("+"+0+"a");
            }

            if(i<oldN) equation.append("=" + (int) (Math.random() * 10+1));
            else equation.append("="+0);

            a.fillRow(i, EquationConvertor.convert(equation.toString()));
  
        }

        // Stream.of(a.getMatrix()).forEach(row->System.out.println(Arrays.toString(row)));
        //System.out.println();
        
        for (int i = 0; i < b.getRows(); i++) {

            StringBuilder equation = new StringBuilder();

            for (int j = 0; j < b.getCols(); j++) {
                if(j<oldN && i<oldN) equation.append("+" + (int) (Math.random() * 10+1) + "b");
                else equation.append("+" + 0 + "b");
            }

            if(i<oldN) equation.append("=" + (int) (Math.random() * 10+1));
            else equation.append("="+0);

            b.fillRow(i, EquationConvertor.convert(equation.toString()));
           
        }

        // Stream.of(b.getMatrix()).forEach(row->System.out.println(Arrays.toString(row)));
        //System.out.println();
        
        long startIme = System.nanoTime();

         Matrix result = this.multiply(a, b, 'm');

         //Stream.of(result.getMatrix()).forEach(row->System.out.println(Arrays.toString(row)));

        long duration = System.nanoTime() - startIme;
        duration = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);
        System.out.println("Computation time = " + duration);
        time += duration;

    }

    private Matrix multiply(Matrix a, Matrix b, char type) {

        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException();
        }

        Matrix result = null;

        if (type == 's') {
            SingleThreaded singleThreaded = new SingleThreaded();
            result = singleThreaded.multiply(a, b);
        } else if (type == 'm') {
            MultiThreaded multiThreaded = new MultiThreaded();
            result = multiThreaded.multiply(a, b);
        } else {
            System.out.println("Wrong input");
            System.exit(1);
        }

        return result;
    }

    public static void main(String[] args) {

        for (int i = 0; i < RUNS; i++) {
            new Main();
        }

        System.out.println("Average computation time = " + (time * 1.0) / RUNS);

    }

}