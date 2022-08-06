import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFilesTwo {
    public static void main(String[] args) {
        try {
            loadData("Greetings.txt");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadData(String name) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }

}
