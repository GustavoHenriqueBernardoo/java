import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

    static final double[] targets = new double[] { 0.5, 0.8, 0.3 };
    static final double PRECISION = 0.1;

    static double result = 0;

    public static void main(String[] args) {

        int runThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(runThreads);

        Future<Double> future = executor.submit(() -> generateNumber(0));
        Future<Double> future2 = executor.submit(() -> generateNumber(1));
        Future<Double> future3 = executor.submit(() -> generateNumber(2));

        // Scanner scan = new Scanner(System.in);
        // System.out.println("Please enter a name to generate a number: ");
        // scan.nextLine();
        // scan.close();

        try {
            future.get();
            future2.get();
            future3.get();

            executor.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Finished running background operations");
    }

    public static double generateNumber(int index) {
        double number = Math.random();
        double difference = difference(number, index);
        while (difference > PRECISION) {
            number = Math.random();
            difference(number, index);
        }

        return number;

    }

    public static double difference(double number, int index) {
        return Math.abs(targets[index] - number);

    }

}
