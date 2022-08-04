import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");

        // Item item = new Item("Coca", 7.00, 100);

        Item[][] items = new Item[][] {
                { new Item("Pepsi", 1.99, 3), new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
                { new Item("Fanta", 1.99, 2), new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
                { new Item("Crush", 1.99, 2), new Item("C-Cola", 2.99, 2), new Item("Berry", 2.49, 1) }
        };

        Machine machine = new Machine(items);

        while (true) {
            System.out.print("Pick a row: ");
            int pickRow = scan.nextInt();

            System.out.print("Pick a spot in the row: ");
            int pickSpot = scan.nextInt();

            // Even though I am declaring a variable here, I am calling the method, so it's
            // counts
            Boolean sold = machine.dispense(pickRow, pickSpot);
            System.out.println("\n" + machine);

            if (sold == true) {
                System.out.println("\nEnjoy your drink! Press 1 to purchase another: ");
            } else {
                System.out.println("\nSorry, we're out of this item. Press 1 to purchase another: ");
            }

            int press1 = scan.nextInt();
            if (press1 != 1) {
                break;
            }

        }

    }
}
