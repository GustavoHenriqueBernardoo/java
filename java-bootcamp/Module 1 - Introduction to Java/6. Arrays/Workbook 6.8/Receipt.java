import java.util.Arrays;

public class Receipt {
    public static void main(String[] args) {

        String[] type = { "Gala", "Granny Smith", "Macintosh" };
        double[] price = { 1.99, 1.49, 1.29 };

        System.out.println("Here's your receipt:\n");

        for (int i = 0; i < type.length; i++) {
            System.out.println("\t" + type[i] + ": $" + price[i]);
        }
    }
}