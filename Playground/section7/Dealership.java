import java.util.Arrays;
import java.util.Scanner;

public class Dealership {
  private Car[] cars;

  // Constructor
  public Dealership(Car[] cars) {
    this.cars = new Car[cars.length];

    for (int i = 0; i < cars.length; i++) {
      this.cars[i] = new Car(cars[i]);
    }

  }

  // Setters
  public void setCar(Car car, int index) {
    // using the copy constructor
    this.cars[index] = new Car(car);
  }

  // getters
  public Car getCar(int index) {
    return new Car(this.cars[index]);
  }

  /**
   * Function name: search
   *
   * @param make   (String)
   * @param budget (int)
   * @return (int) <-------
   *
   *         Inside the function:
   *         1. Loops through every element in the cars field.
   *         2. Skips the run if the element is null.
   *         3. If it finds a car the user wants and can afford:
   *         - println: \nWe found a car in spot <i> \n\n <toString>
   *         - print: If you're interested, type 'yes':
   *         - returns the index
   *         4. If the loop runs and it didn't find a car
   *         - println: \nYour search didn't match any results.\n
   *         - returns 404
   */

  public int sell(String make, int budget) {

    for (int i = 0; i < this.cars.length; i++) {

      if (this.cars[i] == null) {
        continue;
      }
      if (this.cars[i].getMake().equalsIgnoreCase(make) && this.cars[i].getPrice() <= budget) {
        System.out.println("\nWe found a car in spot " + i + " \n\n " + this.cars[i].toString() + "");
        System.out.print("If you're interested, type 'yes':");

        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
          this.cars[i].drive();
        }
        scan.close();
        return i;

      }
    }

    System.out.println("\nYour search didn't match any results.\n");
    return 404;
    // delete the car it was select to sell
    // this.cars[index] = null;
  }

  public String search(String make, int budget) {
    for (int i = 0; i < this.cars.length; i++) {
      if (this.cars[i] == null) {
        continue;
      } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
        return "\nWe found one in spot " + i + "\n" + this.cars[i].toString() + "\nAre you interested ?";
      }
    }
    return "Sorry, we couldn't find any cars";
  }

  public String toString() {
    String temp = "";
    for (int i = 0; i < cars.length; i++) {
      temp += "\nParking spot: " + i + "\n";
      if (this.cars[i] == null) {
        temp += "Empty\n";
      } else {
        temp += this.cars[i].toString() + "\n";
      }
    }
    return temp;
  }
}
