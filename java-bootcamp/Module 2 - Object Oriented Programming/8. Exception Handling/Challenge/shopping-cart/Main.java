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

            System.out.println(store);
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
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

    /**
     * Name: loadItems
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               1. loads items from <fileName>.txt.
     *                               • while loop runs through every line in
     *                               <fileName>
     *                               • scan.nextLine() picks up the entire line.
     *                               • splits each String using the ";" separator.
     *                               • splits both fields in each String using the
     *                               "=" separator.
     *                               • Parse each price into a Double.
     *                               2. adds all items to the store object's items
     *                               field.
     */

}
