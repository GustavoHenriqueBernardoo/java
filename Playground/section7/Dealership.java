import java.util.Arrays;

public class Dealership {
  private Car[] cars;

  // Constructor
  public Dealership() {
    this.cars = new Car[3];

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

  public void sell(int index) {
    this.cars[index].drive();
    // delete the car it was select to sell
    this.cars[index] = null;
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
      temp += "Parking spot: " + i + "\n";
      if (this.cars[i] == null) {
        temp += "Empty\n";
      } else {
        temp += this.cars[i].toString() + "\n";
      }
    }
    return temp;
  }
}
