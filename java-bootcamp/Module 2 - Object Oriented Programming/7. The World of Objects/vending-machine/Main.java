import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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

        Item item = machine.getItems(0, 0);

        item.setPrice(9.99);
        // item.setName("Dolly Guarana");
        item.setQuantity(10);

        machine.setItems(item, 0, 0);

        machine.dispense(0, 0);
        machine.dispense(0, 0);
        // System.out.println(machine.getItems(0, 0) + "\n");

        // Item item = new Item(source)

        System.out.println(machine);

    }
}
