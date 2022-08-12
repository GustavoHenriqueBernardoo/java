import models.Movie;
import models.Store;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        /*
         * The Shawshank Redemption--Blue-Ray--9.2
         * 
         * The Godfather--Blue-Ray--9.1
         * 
         * The Godfather: Part II--DVD--9.0
         */
        Movie[] movies = new Movie[] {
                new Movie("The Shawshank Redemption", "Blue-Ray", 9.2),
                new Movie("The Godfather", "Blue-Ray", 9.1),
                new Movie("The Godfather: Part II", "DVD", 9.0),
        };

        var store = new Store();

        for (int i = 0; i < movies.length; i++) {
            store.addMovie(movies[i]);
        }

        store.action("The Godfather", "rent");
        store.action("The Godfather: Part II", "rent");
        store.action("The Godfather", "sell");

        System.out.println(store);

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

}
