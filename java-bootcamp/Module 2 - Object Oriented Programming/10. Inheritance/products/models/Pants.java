package models;

import java.util.Objects;

public class Pants extends Product {
  private int waits;

  public Pants(int waits, double price, String color, String brand) {
    super(price, color, brand);
    this.waits = waits;
  }

  public Pants(Pants source) {
    super(source);
    this.waits = source.waits;
  }

  public int getWaits() {
    return this.waits;
  }

  public void setWaits(int waits) {
    this.waits = waits;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pants)) {
      return false;
    }
    Pants pants = (Pants) o;
    return waits == pants.waits &&
        super.getPrice() == pants.getPrice() &&
        super.getColor().equals(pants.getColor()) &&
        super.getBrand().equals(pants.getBrand());
  }

  @Override
  public int hashCode() {
    return Objects.hash(waits, super.getPrice(), super.getColor(), super.getBrand());
  }

}