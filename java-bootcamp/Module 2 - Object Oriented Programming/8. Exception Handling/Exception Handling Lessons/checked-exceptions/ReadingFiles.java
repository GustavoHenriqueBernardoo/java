import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFiles {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Greetings.txt");
            Scanner scan = new Scanner(fis);

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        }

        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
