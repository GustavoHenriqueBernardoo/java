import java.util.Scanner;

import models.Car;
import models.Dealership;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Car[] cars = new Car[] {
                new Car("Nissan", 5000),
                new Car("Honda", 12000),
        };
        // cars[1].setMake(" ");
        // cars[1].setPrice(-8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            if (dealership.isEmpty()) {
                System.out.println("\nWe're all sold out!");
                break;
            }
            System.out.println(dealership);
            System.out.print("Enter the spot number of the car you want to buy: ");
            if (scan.hasNextInt()) {
                int spot = scan.nextInt();
                if (spot < cars.length) {
                    if (dealership.getCar(spot) == null) {
                        System.out.println("Spot " + spot + " is empty.");
                        continue;
                    }
                    dealership.sell(spot);

                } else {
                    System.out.println("\nPlease Choose a valid spot");
                    continue;
                }
            } else {

                scan.nextLine();
                System.out.println("\nInvalid Input");
                continue;
            }

            System.out.println("Type Yes to continue shopping");
            scan.nextLine();
            String continueShopping = scan.nextLine();
            if (continueShopping.equalsIgnoreCase("yes")) {
                continue;
            } else {
                break;
            }
        }
        scan.close();

    }
}
