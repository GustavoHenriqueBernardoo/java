import java.util.Arrays;
import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");

        // – Store the value.
        int userInput = scan.nextInt();
        scan.nextLine();

        String[][] database = new String[userInput][3];

        for (int i = 0; i < database.length; i++) {
            System.out.println("\n\tFigure " + (i + 1));
            System.out.print("\t - Name: ");
            String name = scan.nextLine();
            database[i][0] = name;

            System.out.print("\t - Date of birth: ");
            String birth = scan.nextLine();
            database[i][1] = birth;

            System.out.print("\t - Occupation: ");
            String occupation = scan.nextLine();
            database[i][2] = occupation;

            System.out.print("\n");
        }

        System.out.println("These are the values you stored:");
        // call print2DArray.
        print2DArray(database);

        System.out.print("\nWho do you want information on? ");
        String search = scan.nextLine();

        for (int i = 0; i < database.length; i++) {
            if (search.equals(database[i][0])) {
                System.out.println("\tName:" + database[i][0]);
                System.out.println("\tDate of birth:" + database[i][1]);
                System.out.println("\tOccupation:" + database[i][2]);
            }
        }
        scan.close();
    }

    public static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
