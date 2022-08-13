import models.*;

public class Main {

    public static void main(String[] args) {
        Item[][] inventory = new Item[][] {
                { new Item("Pepsi", 1.99), new Item("Crush", 1.99), new Item("Cola", 1.99) },
                { new Item("Honey Oats", 3.99), new Item("Fruit Loops", 1.99), new Item("Cheerios", 2.99) },
                { new Item("Milk", 4.99), new Item("Eggs", 0.99), new Item("Cheese", 1.89) },
                { new Item("Pepperoni", 2.99), new Item("Salami", 4.49), new Item("Mortadella", 4.99) },
                { new Item("Celery", 0.99), new Item("Spinach", 0.99), new Item("Coriander", 1.29) },
                { new Item("Shirt", 12.99), new Item("Pants", 24.99), new Item("Sweater", 18.99) },
                { new Item("Phone", 549.99), new Item("Printer", 349.99), new Item("Television", 1099) }
        };

        Store store = new Store();

        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[i].length; j++) {
                store.setItem(i, j, inventory[i][j]);
            }
        }

        System.out.println("\n\t******************************JAVA GROCERS******************************\n");

        System.out.println(store + "\n");

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
