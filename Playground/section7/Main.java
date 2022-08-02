import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    Car[] cars = new Car[] {
        new Car("Nissan", 5000, 2020, "red", new String[] { "tires", "keys" }),
        new Car("Dodge", 8500, 2022, "blue", new String[] { "tires", "keys" }),
        new Car("Nissan", 5000, 2017, "yellow", new String[] { "filter", "tires" }),
    };

    Dealership dealership = new Dealership();

    // fori = create a for loop using the length of the newest array
    for (int i = 0; i < cars.length; i++) {
      dealership.setCar(cars[i], i);

    }

    // Is going to return the car in the index of 0
    // System.out.println(dealership.getCar(0));

    System.out.println(cars[0].toString());

  }
}
