package src.main;

public class Account {

  private String id;
  private String name;
  private double balance;

  public Account(String id, String name, double balance) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null/blank");
    }

    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Id cannot be null/blank");
    }

    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be less then zero");
    }
    this.id = id;
    this.name = name;
    this.balance = balance;
  }

  public Account(Account source) {
    this.id = source.id;
    this.name = source.name;
    this.balance = source.balance;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Id cannot be null/blank");
    }
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null/blank");
    }
    this.name = name;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be less then zero");
    }
    this.balance = balance;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() +
        "\t" + getId() + "" +
        "\t" + getName() + "" +
        "\t" + getBalance() + "";
  }

}
