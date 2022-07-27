import java.util.Arrays;

public class Weather {
    public static void main(String[] args) {

        double[] celsius = { 12.5, 14.5, 17.0, 21.0, 23.0, 18.5, 20.0 };
        double[] fahrenheit = celciusToFahrenheit(celsius);

        // Task 4, Call printTemperatures for celsius and fahrenheit.

        printTemperatures(celsius, "Celsius");
        printTemperatures(fahrenheit, "fahrenheit");
    }

    public static double[] celciusToFahrenheit(double[] celsius) {
        double[] fahrenheit = Arrays.copyOf(celsius, celsius.length);
        for (int i = 0; i < fahrenheit.length; i++) {
            fahrenheit[i] = (celsius[i] / 5 * 9) + 32;
        }
        return fahrenheit;
    }

    public static void printTemperatures(double[] temp, String type) {
        System.out.print(type + ": ");

        for (int i = 0; i < temp.length; i++) {
            String twoDecimals = String.format("%.2f", temp[i]);
            System.out.print(twoDecimals + " ");
        }
        System.out.println("\n");

    }

}
