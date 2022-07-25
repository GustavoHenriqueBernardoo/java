import java.util.Scanner;

public class SignUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to JavaGram! Let's sign you up.");
        

        //Task 1 - Using Scanner, ask the user questions

        //Ask for their first name.
        System.out.println("\nWhat's your first name? ");
        String name = scan.nextLine();
        //Ask for their last name.
        System.out.println("\nWhat's your last name? ");
        String lastName = scan.nextLine();
        //Ask: how old are you?
        System.out.println("\nHow old are you? ");
        int age = scan.nextInt();

        scan.nextLine();

        System.out.println("\nEnter a username? ");
        String userName = scan.nextLine();
        /* Ask them to make a username. SIDE NOTE:
           – nextLine() gets "skipped" if you put it ahead of nextInt() , nextDouble(), nextLong().
           – You will understand why this happens when we cover Delimiters in the next section (Booleans and Conditionals).
           – For now, just know that the solution is to add an extra nextLine().
        */
        //Ask what city they live in.
        System.out.println("\nWhat city do you live? ");
        String city = scan.nextLine();
        //Ask what country that's from.
        System.out.println("\nWhat's your country? ");
        String country = scan.nextLine();


        //Task 2 - Print their information. 

        System.out.println("Thank you for joining JavaGram!");

        //Print their information like so:
        System.out.println("Your information:");
        System.out.println("\tFirst Name:" + name);
        System.out.println("\tLast Name:" + lastName);
        System.out.println("\tAge:" + age);
        System.out.println("\tUsername:" + userName);
        System.out.println("\tCity:" + city);
        System.out.println("\tCountry:" + country);
        // Your information:
        //        First Name: Rayan
        //        Last Name: Slim
        //        Age: 27
        //        Username: monotonic_relu
        //        City: Ottawa
        //        Country: Canada
        //


        //close scanner. It's good practice :D ! 
        scan.close();
    }
}
