package models;

public class Movie {
  // fields
  private String name;
  private String format;
  private double rating;
  private double sellingPrice;
  private double rentalPrice;
  private boolean isAvailable;

  // constructor
  public Movie(String name, String format, double rating) {
    if (name.isBlank() || name == null) {
      throw new IllegalArgumentException("Name of the movie cannot be null/blank");
    }
    if (!format.equalsIgnoreCase("DVD")) {
      if (!format.equalsIgnoreCase("Blue-Ray")) {
        throw new IllegalAccessError("Format has to be equal to DVD or Blue-ray");

      }
    }

    if (rating > 10 || rating < 0) {
      throw new IllegalArgumentException("Rating cannot be less than 0 or greater than 10");
    }

    this.name = name;
    this.format = format;
    this.rating = rating;
    this.isAvailable = true;
    this.sellingPrice = format.equalsIgnoreCase("Blue-ray") ? 4.25 : 2.25;
    this.rentalPrice = format.equalsIgnoreCase("Blue-ray") ? 1.99 : 0.99;
  }

  // copy Constructor
  public Movie(Movie source) {
    this.name = source.name;
    this.format = source.format;
    this.rating = source.rating;
    this.isAvailable = source.isAvailable;
    this.sellingPrice = source.sellingPrice;
    this.rentalPrice = source.rentalPrice;
  }

  public String getName() {
    return name;
  }

  public String getFormat() {
    return format;
  }

  public double getRating() {
    return rating;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setName(String name) {
    if (name.isBlank() || name == null) {
      throw new IllegalArgumentException("Name of the movie cannot be null/blank");
    }
    this.name = name;
  }

  // When the format change, the selling price and Rental Price has to change too
  public void setFormat(String format) {
    if (!format.equalsIgnoreCase("DVD") || !format.equalsIgnoreCase("Blue-Ray")) {
      throw new IllegalAccessError("Format has to be equal to DVD or Blue-ray");
    }
    this.format = format;
    setSellingPrice(format.equalsIgnoreCase("Blue-ray") ? 4.25 : 2.25);
    setRentalPrice(format.equalsIgnoreCase("Blue-ray") ? 1.99 : 0.99);

  }

  public void setRating(double rating) {
    if (rating > 10 || rating < 0) {
      throw new IllegalArgumentException("Rating cannot be less than 0 or greater than 10");
    }
    this.rating = rating;
  }

  private void setSellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  private void setRentalPrice(double rentalPrice) {
    this.rentalPrice = rentalPrice;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public String toString() {
    return "\t Name: " + name + "\n" +

        "\t Format: " + format + "\n" +

        "\t Rating: " + rating + "\n" +

        "\t Selling Price: " + sellingPrice + "\n" +

        "\t Rental Price: " + rentalPrice + "\n" +

        "\t Availability: " + (isAvailable ? "In-Stock" : "rented") + "\n";
  }

}
