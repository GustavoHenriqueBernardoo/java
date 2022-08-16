package src.main.models;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return this.movies.contains(movie);
    }

    public void sellMovie(String name) {
        this.movies.removeIf(movie -> movie.getName().equals(name));
    }

    public void rentMovie(String name) {
        this.movies.get(getMovieIndex(name)).setAvailable(false);
    }

    public void returnMovie(String name) {
        this.movies.get(getMovieIndex(name)).setAvailable(true);
    }

    public int getMovieIndex(String name) {

        return IntStream.range(0, this.movies.size())
                .filter(index -> this.movies.get(index).getName().equals(name))
                .findFirst()
                .orElse(-1000);
    }

}
