import java.util.Scanner;

public class RuntimeException3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a number: ");
            if (scan.hasNextInt()) {
                System.out.println(scan.nextInt());
                break;
            } else {
                scan.nextLine();
            }
        }
        scan.close();
    }
}