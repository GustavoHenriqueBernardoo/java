import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    Car[] cars = new Car[] {
        new Car("Nissan", 5000, 2020, "red", new String[] { "tires", "keys" }),
        new Car("Dodge", 8500, 2022, "blue", new String[] { "tires", "keys" }),
        new Car("Skyline", 80000, 2020, "Sky Blue", new String[] { "filter", "tires" }),
        new Car("Eclipse", 4000, 2017, "Green", new String[] { "filter", "tires" }),
        new Car("Mazda", 5700, 2018, "orange", new String[] { "filter", "tires" }),
    };

    Dealership dealership = new Dealership(cars);

    System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
    System.out.print("Welcome! Enter the type of car you're looking for: ");
    // pick up make
    String make = scan.nextLine();
    System.out.print("Enter your budget: ");
    // pick up budget
    int budget = scan.nextInt();

    int searchResult = dealership.sell(make, budget);

    if (searchResult == 404) {
      System.out.println(" Feel free to browse through our collection of cars.\n");
      System.out.println(dealership);
    }

    // System.out.println(searchResult);

    // System.out.println(dealership);
    // Is going to return the car in the index of 0
    // System.out.println(dealership.getCar(0));

  }
}
