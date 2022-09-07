package src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {

  public enum Type {
    WITHDRAW,
    DEPOSIT
  };

  private Type type;
  long timestamp;
  String id;
  double amount;

  public Transaction(Type type, long timestamp, String id, double amount) {
    this.type = type;
    this.timestamp = timestamp;
    this.id = id;
    this.amount = amount;

  }

  public Transaction(Transaction source) {
    this.timestamp = source.timestamp;
    this.id = source.id;
    this.amount = source.amount;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String returnDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date(this.timestamp * 1000);

    return formatter.format(date);

  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Transaction)) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(type, transaction.type) && timestamp == transaction.timestamp
        && Objects.equals(id, transaction.id) && amount == transaction.amount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, timestamp, id, amount);
  }

  @Override
  public String toString() {
    return type + "    " +
        "\t" + returnDate() + "" +
        "\t" + this.getId() + "" +
        "\t$" + this.getAmount() + "";
  }

}
