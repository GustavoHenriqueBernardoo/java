import java.util.Scanner;

public class Survey {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome, thank you for taking the survey");

    System.out.println("What is your names?");
    String name = scan.nextLine();

    System.out.println("How much money do you spend on coffe?");
    double coffePrice = scan.nextDouble();

    scan.close();
  }
}
