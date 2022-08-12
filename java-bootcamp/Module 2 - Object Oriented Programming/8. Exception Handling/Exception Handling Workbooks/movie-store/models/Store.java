package models;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;

public class Store {
  // fields
  ArrayList<Movie> movies;

  // constructor
  public Store() {
    this.movies = new ArrayList<Movie>();

  }

  public Movie getMovie(int index) {
    return new Movie(movies.get(index));
  }

  public void setMovie(int index, Movie movie) {
    movies.set(index, new Movie(movie));
  }

  public void addMovie(Movie movie) {
    movies.add(movie);
  }

  /**
   * @param movieName
   * @param action
   * 
   *                  the action parameters will trigger which action the function
   *                  will take
   *                  if sell is going to sell the movie and remove from the
   *                  movies arrayList
   *                  if is rent will the set the availability to false
   *                  and if is return, will set back the availability to true
   */
  public void action(String movieName, String action) {

    if (movies.isEmpty()) {
      throw new IllegalStateException("Movies arrays is empty, you shouldn't call action");
    }

    if (movieName.isBlank() || movieName == null) {
      throw new IllegalArgumentException("movieName cannot be null/blank");
    }

    if (!(action.equalsIgnoreCase("sell") || action.equalsIgnoreCase("rent") || action.equalsIgnoreCase("return"))) {
      throw new IllegalArgumentException("action must be sell/rent or return");
    }

    if (action.equalsIgnoreCase("sell")) {
      for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
          if (movies.get(i).isAvailable()) {
            movies.remove(i);
          } else {
            throw new IllegalStateException("You cannot sell a movie if it's rented");
          }
        }
      }
    } else if (action.equalsIgnoreCase("rent")) {
      for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
          movies.get(i).setAvailable(false);
        }
      }
    } else if (action.equalsIgnoreCase("return")) {
      for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).getName().equalsIgnoreCase(movieName)) {
          movies.get(i).setAvailable(true);
        }
      }
    }
  }

  public String toString() {
    String temp = "";

    for (int i = 0; i < movies.size(); i++) {
      temp += "\n";
      temp += movies.get(i).toString();
      temp += "\n";

    }

    return temp;
  }

}
