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
    this.name = name;
    this.format = format;
    this.rating = rating;
    this.isAvailable = true;
    this.sellingPrice = format.equalsIgnoreCase("Blue-ray") ? 4.25 : 2.25;
    this.rentalPrice = format.equalsIgnoreCase("Blue-ray") ? 1.99 : 0.99;
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
    this.name = name;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public void setSellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public void setRentalPrice(double rentalPrice) {
    this.rentalPrice = rentalPrice;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

}
