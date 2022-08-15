import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import models.*;

public class Main {
    static Store store = new Store();

    static Cart cart = new Cart();

    public static void main(String[] args) {

        try {
            loadItem("products.txt");
            manageItems();

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");

            System.out.println(store);
        }

    }

    /**
     * Name: manageItems
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. Creates an infinite loop:
     * • The user can choose to a) add or b) remove c) checkout.
     * • case a: asks for the aisle and item number. Then, adds item to cart.
     * • case b: asks for the name. Then, removes item from cart.
     * • case c: prints the receipt and closes Scanner.
     * • Prints the updated shopping cart.
     */

    public static void manageItems() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\t******************************JAVA GROCERS******************************\n");

        System.out.println(store);

        while (true) {
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String userInput = scan.nextLine();
            switch (userInput) {
                case "a":
                    System.out.print("\nChoose an aisle number between: 1 – 7: ");
                    int aisle = scan.nextInt() - 1;
                    scan.nextLine();
                    System.out.print("Choose an item number between: 1 – 3: ");
                    int itemNumber = scan.nextInt() - 1;
                    scan.nextLine();

                    Item item = store.getItem(aisle, itemNumber);

                    if (!cart.add(item)) {
                        System.out.println(item.getName() + " is already in your shopping cart.\n");
                    } else {
                        System.out.println(item.getName() + " was added to your shopping cart.\n");

                    }
                    break;
                case "b":

                    break;
            }
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
