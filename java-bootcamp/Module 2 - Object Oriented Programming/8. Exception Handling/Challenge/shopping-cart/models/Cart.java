package models;

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void setItem(int index, Item item) {
        items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (items.contains(item)) {
            return false;
        }

        items.add(new Item(item));
        return true;
    }

    public void removeItem(String name) {
        if (items.isEmpty()) {
            throw new IllegalStateException("You cannot remove any items from cart because it's already empty");
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                items.remove(i);
            }
        }
    }

    public String checkout() {
        if (items.isEmpty()) {
            throw new IllegalStateException("You can't call checkout if the cart is empty");
        }

        double subTotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subTotal += items.get(i).getPrice();
        }
        double tax = (subTotal * 13) / 100;
        double total = subTotal + tax;

        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + subTotal + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + total + "\n";
    }

    public String toString() {
        String temp = "\n";

        for (int index = 0; index < items.size(); index++) {
            temp += items.get(index).toString();
            temp += "\n";
        }

        return temp;
    }

    public boolean isEmpty() {
        return items.isEmpty() ? true : false;
    }

    /**
     * Name: checkout
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Calculates the subtotal (price before tax).
     *         2. Calculates the tax (assume tax is 13%).
     *         3. Calculates total: subtotal + tax
     *         4. Returns a String that resembles a receipt. See below.
     */

}
