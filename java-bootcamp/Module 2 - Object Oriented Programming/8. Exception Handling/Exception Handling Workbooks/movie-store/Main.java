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
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c)
     * return d) exit.
     * • case a: ask for the name and sell.
     * • case b: ask for the name and rent.
     * • case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's
     *                               movie field.
     *                               Hint: You will need to 'split' a String into
     *                               three Strings.
     */

    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanDoc = new Scanner(fis);

        while (scanDoc.hasNextLine()) {
            String movieLine = scanDoc.nextLine();
            String[] stringArr = movieLine.split("--");

            Movie movie = new Movie(stringArr[0], stringArr[1], Double.parseDouble(stringArr[2]));

            store.addMovie(movie);

        }

    }

}
