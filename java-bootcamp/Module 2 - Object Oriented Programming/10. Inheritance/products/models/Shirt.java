package models;

import java.util.Objects;

public class Shirt extends Product {
  private String size;

  public Shirt(String size, double price, String color, String brand) {
    super(price, color, brand);
    this.size = size;
  }

  public Shirt(Shirt source) {
    super(source);
    this.size = source.size;
  }

  public String getSize() {
    return this.size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Shirt)) {
      return false;
    }
    Shirt shirt = (Shirt) o;
    return size == shirt.size &&
        super.getPrice() == shirt.getPrice() &&
        super.getColor().equals(shirt.getColor()) &&
        super.getBrand().equals(shirt.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, super.getBrand(), super.getColor(), super.getPrice());
  }

}