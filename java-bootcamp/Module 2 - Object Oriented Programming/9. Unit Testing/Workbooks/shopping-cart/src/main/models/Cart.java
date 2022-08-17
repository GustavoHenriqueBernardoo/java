package src.main.models;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        }
        items.add(new Item(item));
        return true;
    }

    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        this.items.removeIf(item -> item.getName().equals(name));
    }

    public void clear() {
        this.items.removeAll(items);
    }

    public double getSubtotal() {
        return this.items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
    }

    public double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        double tax = subtotal * 0.13;

        return Double.parseDouble(formatter.format(tax));

    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + getSubtotal() + "\n" +
                "\tTax: $" + getTax(getSubtotal()) + "\n" +
                "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }

    public boolean contains(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).equals(new Item(item))) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
