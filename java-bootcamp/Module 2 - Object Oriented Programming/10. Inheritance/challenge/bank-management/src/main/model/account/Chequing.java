package src.main.model.account;

import src.main.Account;
import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {

  private static final double OVERDRAFT_FEE = 5.50;
  private static final double OVERDRAFT_LIMIT = -200;

  private static final double INCOME_EXCEEDS = 3000;
  private static final double TAX_RATE = 0.15;

  public Chequing(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Chequing(Chequing source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    double result = super.round(super.getBalance() + amount);
    super.setBalance(result);

  }

  @Override
  public boolean withdraw(double amount) {
    double available = super.getBalance() - amount;

    if (available < OVERDRAFT_LIMIT) {
      return false;
    } else if (amount > super.getBalance()) {
      super.setBalance(super.round(super.getBalance() - amount - OVERDRAFT_FEE));
    } else {
      super.setBalance(super.round(super.getBalance() - amount));
    }
    return true;
  }

  @Override
  public void tax(double income) {

    double tax = Math.max(0, income - INCOME_EXCEEDS) * TAX_RATE;
    super.setBalance(super.round(super.getBalance() - tax));

  }

  @Override
  public Account clone() {
    return new Chequing(this);
  }

}
