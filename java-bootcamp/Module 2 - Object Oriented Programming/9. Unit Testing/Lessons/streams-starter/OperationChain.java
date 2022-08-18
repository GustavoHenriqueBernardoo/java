import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OperationChain {

    static ArrayList<Double> prices = new ArrayList<Double>();

    public static void main(String[] args) {
        prices.add(1.99);
        prices.add(4.99);
        prices.add(10.99);
        prices.add(15.99);

        ArrayList<Double> updatePrices = new ArrayList<Double>();

        updatePrices.addAll(prices.stream()
                .filter(price -> price < 5)
                .map(price -> price * 1.13)
                .collect(Collectors.toList()));

        System.out.println(updatePrices);

        // filterLowPrices(updatePrices);
        // tax(updatePrices);

    }

    // public static void filterLowPrices(ArrayList<Double> lowPrices) {
    // for (int i = 0; i < prices.size(); i++) {
    // if (prices.get(i) < 5) {
    // lowPrices.add(prices.get(i));
    // }
    // }
    // }

    // public static void tax(ArrayList<Double> withTax) {
    // for (int i = 0; i < withTax.size(); i++) {
    // withTax.set(i, withTax.get(i) * 1.13);
    // }
    // }

}
