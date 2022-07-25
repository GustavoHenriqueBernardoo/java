import java.util.Scanner;

public class Delimeters {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter two Integers ( on the same line)");
    String num =  scan.nextLine();

    System.out.println("Enter two very big Integers ( on the same line)");
    String bigNum = scan.nextLine();

    System.out.println("Enter two very decimals ( on the same line)");
    String decimal = scan.nextLine();


    System.out.println("Enter two text values ( on the same line)");
    String text = scan.nextLine();

    System.out.println("\tIntegers are: " + num);
    System.out.println("\tThe bigInts are: " + bigNum);
    System.out.println("\tDecimals: " + decimal);
    System.out.println("\tWords: " + text);
  }
}
