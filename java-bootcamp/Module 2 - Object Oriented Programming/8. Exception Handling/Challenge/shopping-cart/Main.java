import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import models.*;

public class Main {
    static Store store = new Store();

    static Cart cart = new Cart();

    public static void main(String[] args) {

        try {
            loadItem("products.txt");
            manageItems();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");

            System.out.println(store);
        }

    }

    public static void manageItems() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String userInput = scan.nextLine();
            if (!(userInput.equals("a") || userInput.equals("b") || userInput.equals("c"))) {
                System.out.println("Enter a valid option");
                continue;
            }
            switch (userInput) {
                case "a":
                    System.out.print("\nChoose an aisle number between: 1 – 7: ");

                    int row = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                    scan.nextLine();

                    if (row == 404) {
                        System.out.println("Invalid Input");
                        continue;
                    }

                    System.out.print("Choose an item number between: 1 – 3: ");
                    int column = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                    scan.nextLine();

                    if (column == 404) {
                        System.out.println("Invalid Input");
                    }

                    Item item = store.getItem(row, column);

                    if (!cart.add(item)) {
                        System.out.println("\n" + item.getName() + " is already in your shopping cart.\n");
                    } else {
                        System.out.println("\n" + item.getName() + " was added to your shopping cart.\n");

                    }
                    break;
                case "b":
                    if (cart.isEmpty()) {
                        System.out.println("\nCart is empty");
                        continue;
                    }
                    System.out.print("Enter the item you'd like to remove: ");
                    String name = scan.nextLine();

                    cart.removeItem(name);

                    break;

                case "c":
                    if (cart.isEmpty()) {
                        System.out.println("\nCart is empty");
                        continue;
                    }
                    System.out.println(cart.checkout());
                    break;
            }

            System.out.println("\n\nSHOPPING CART\n\n" + cart);

            System.out.print("Enter anything to continue: ");
            scan.nextLine();
        }
    }

    public static void loadItem(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanTxt = new Scanner(fis);

        int count = 0;
        while (scanTxt.hasNextLine()) {

            String line = scanTxt.nextLine();
            String[] lineItem = line.split(";");

            for (int i = 0; i < lineItem.length; i++) {

                String[] item = lineItem[i].split("=");

                String name = item[0];
                double price = Double.parseDouble(item[1]);

                store.setItem(count, i, new Item(name, price));
            }

            count++;
        }

    }
}
