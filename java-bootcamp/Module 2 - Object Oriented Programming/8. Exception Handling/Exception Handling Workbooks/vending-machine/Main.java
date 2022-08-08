import java.util.Scanner;

import models.Item;
import models.Machine;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");

        Item[][] items = new Item[][] {
                {
                        new Item("Pepsi", 1.99, 0),
                        new Item("Fresca", 1.49, 3),
                        new Item("Brisk", 2.49, 2)
                },
                {
                        new Item("Fanta", 1.99, 2),
                        new Item("Barq's", 1.49, 2),
                        new Item("A & W", 2.49, 3)
                },
                {
                        new Item("Crush", 1.99, 2),
                        new Item("C-Cola", 1.49, 2),
                        new Item("Berry", 2.49, 1)
                }
        };

        Machine machine = new Machine(items);

        System.out.println(machine);

        // System.out.println(machine.getItem(row, spot));

        while (true) {
            System.out.print("Pick a row: ");
            int row = 0;
            int spot = 0;
            if (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("\nINVALID INPUT\n");
                continue;
            }

            row = scan.nextInt();

            if (row > machine.getLength()) {
                System.out.println("\nINVALID RANGE\n");
                continue;
            }

            System.out.print("Pick a spot in the row: ");

            if (!scan.hasNextInt()) {
                System.out.println("\nINVALID INPUT\n");
                continue;
            }
            spot = scan.nextInt();

            if (spot > machine.getRowLength()) {
                System.out.println("\nINVALID RANGE\n");
                continue;
            }

            if (machine.getItem(row, spot).getQuantity() == 0) {
                System.out.println(
                        "\nWe are out of " + machine.getItem(row, spot).getName() + ". Please Choose another drink\n");
                continue;
            }
            machine.dispense(row, spot);
            System.out.println("\n" + machine);
            System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");
            if (!scan.next().equalsIgnoreCase("1")) {
                break;
            }
        }
        scan.close();
    }
}
