import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.swing.SpinnerDateModel;

public class Main {

    static final String SALES = "data/sales.csv"; // Use backslash Windows users

    static double furniture = 0;
    static double technology = 0;
    static double officeSupplies = 0;
    static double total = 0;

    public static void main(String[] args) {

        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());

            int numThreads = Runtime.getRuntime().availableProcessors();
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            Future<Double> future = executor.submit(() -> average(path, "Furniture"));
            Future<Double> future2 = executor.submit(() -> average(path, "Technology"));
            Future<Double> future3 = executor.submit(() -> average(path, "Office Supplies"));
            Future<Double> future4 = executor.submit(() -> totalAverage(path));

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
            String name = scan.nextLine();

            try {
                furniture = future.get();
                technology = future2.get();
                officeSupplies = future3.get();
                total = future4.get();

                executor.shutdown();

                System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
                System.out.println("Average Furniture Sales: " + furniture);
                System.out.println("Average Technology Sales: " + technology);
                System.out.println("Average Office Supplies Sales: " + officeSupplies);
                System.out.println("Total Average: " + total);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            scan.close();

        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Double average(Path path, String category) {
        try {

            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(values -> values[0].equals(category))
                    .mapToDouble(values -> Double.valueOf(values[1]) * Double.valueOf(values[2]))
                    .average().getAsDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }

    public static Double totalAverage(Path path) {
        try {
            return Files.lines(path)
                    .skip(1)
                    .map(line -> line.split(","))
                    .mapToDouble(values -> Double.parseDouble(values[1]) * Double.parseDouble(values[2]))
                    .average().getAsDouble();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 0.0;
        }

    }

}
