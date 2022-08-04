public class Item {

  // fields
  private String name;
  private double price;
  private int quantity;

  // Constructor
  public Item(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  // Copy Constructor
  public Item(Item source) {
    this.name = source.name;
    this.price = source.price;
    this.quantity = source.quantity;
  }

  // setters
  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  // getters
  public String getName() {
    return this.name;
  }

  public double getPrice() {
    return this.price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public String toString() {

    return this.getName() + ": " + this.getPrice() + " (" + this.quantity + ")";
  }
}
