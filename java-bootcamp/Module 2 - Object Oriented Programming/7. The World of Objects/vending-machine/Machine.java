import java.util.Arrays;

public class Machine {

    // fields
    private Item[][] items;

    // constructor
    public Machine(Item[][] items) {
        this.items = new Item[items.length][items[0].length];

        // copy Constructor
        for (int i = 0; i < this.items.length; i++) {
            for (int j = 0; j < this.items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    public Item getItems(int row, int spot) {
        return new Item(this.items[row][spot]);
    }

    public void setItems(Item item, int row, int spot) {
        this.items[row][spot] = new Item(item);
    }

    public Boolean dispense(int row, int spot) {
        int currentItemQuantity = this.items[row][spot].getQuantity();

        if (currentItemQuantity > 0) {
            this.items[row][spot].setQuantity(currentItemQuantity - 1);
            return true;
        }

        return false;
    }

    public String toString() {
        String temp = "";

        for (int i = 0; i < this.items.length; i++) {
            temp += "\t";
            for (int j = 0; j < this.items[i].length; j++) {

                temp += this.items[i][j].toString() + " ";
            }
            temp += "\n\n";
        }

        temp += "\t************************************************";
        return temp;
    }
}
