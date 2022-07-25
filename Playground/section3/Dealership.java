import java.util.Scanner;

public class Dealership{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to the java dealership");
    System.out.println(" \tSelect option 'a' to buy a car");
    System.out.println(" \tSelect option 'b' to sell a car");

    String option = scan.nextLine();

    switch(option){
      case "a": 
        System.out.println("What is your budget?");
        int budget = scan.nextInt();
        if(budget >= 10000){
          System.out.println("Great A nissan altima is available for $10.000");
          scan.nextLine();
          System.out.println("\nDo you have insurance? Yes or no?");
          String insurance = scan.nextLine();
          System.out.println("\nDo you have a driver's license? Yes or no?");
          String license = scan.nextLine();
          System.out.println("\nWhat is your credit score?");
          int creditScore = scan.nextInt();
          if(insurance.equals("yes") && license.equals("yes") && creditScore > 660){
            System.out.println("Sold! Pleasure doing business with you");
          }else{
            System.out.println("I am sorry, you are no eligible");
          }
        }else{
          System.out.println("We Don't sell cars under $10, 000, Sorry!");
        }
      break;
      case "b": 
        System.out.println("\nWhat is your car valued at?");
        int value = scan.nextInt();

        System.out.println("\nWhat is your selling price?");
        int price = scan.nextInt();

        if( value > price && price < 30000){
          System.out.println("\nWe will buy your car");
        }else{
          System.out.println("\nI am sorry I can't buy your car");
        }
        break;
      default: System.out.println("Invalid option");
    }

    scan.close();
  }
}