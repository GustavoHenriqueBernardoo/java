import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;

import models.Movie;
import models.Store;

public class Main {

    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        // Movie[] movies = new Movie[] {
        // new Movie("The Shawshank Redemption", "Blue-Ray", 9.2),
        // new Movie("The Godfather", "Blue-Ray", 9.1),
        // new Movie("The Godfather: Part II", "DVD", 9.0),
        // };
        //
        // for (int i = 0; i < movies.length; i++) {
        // store.addMovie(movies[i]);
        // }
        //
        // store.action("The Godfather", "rent");
        // store.action("The Godfather: Part II", "rent");

        // =============================================================================

        try {
            loadMovies("movies.txt");

            System.out.println("MOVIES LOADED\n\n");

            System.out.println(store);

            manageMovies();

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process completed");
        }

    }

    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\nWould you like to:  \n\ta) purchase\n\tb) rent \n\tc) return");
            char userInput = scan.nextLine().charAt(0);

            if (!(userInput == 'a' || userInput == 'b' || userInput == 'c')) {
                scan.close();
                break;
            }

            System.out.println("Enter the title of the movie: ");
            String movieName = scan.nextLine();

            if (movieName.isBlank() || movieName == null) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }

            switch (userInput) {
                case 'a':
                    if (store.getMovie(movieName).isAvailable()) {
                        store.action(movieName, "sell");
                        break;
                    } else {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        continue;
                    }
                case 'b':
                    store.action(movieName, "rent");
                    break;
                case 'c':
                    store.action(movieName, "return");
                    break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);

        }

    }

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanDoc = new Scanner(fis);

        while (scanDoc.hasNextLine()) {
            String line = scanDoc.nextLine();
            String[] word = line.split("--");

            Movie movie = new Movie(word[0], word[1], Double.parseDouble(word[2]));

            store.addMovie(movie);

        }
        scanDoc.close();
    }

}
