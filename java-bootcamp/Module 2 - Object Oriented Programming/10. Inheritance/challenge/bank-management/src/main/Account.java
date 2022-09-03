package src.main;

import java.text.DecimalFormat;

public abstract class Account {

  private String id;
  private String name;
  private double balance;

  public abstract void deposit(double amount);

  public abstract boolean withdraw(double amount);

  protected double round(double amount) {
    DecimalFormat formatter = new DecimalFormat("#.##");
    return Double.parseDouble(formatter.format(amount));
  }

  public Account(String id, String name, double balance) {
    if (name == null || name.isEmpty() || id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Name or id cannot be null/blank");
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
    this.balance = balance;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() +
        "\t" + this.getName() + "" +
        "\t" + this.getId() + "" +
        "\t" + this.getBalance() + "";
  }

}
