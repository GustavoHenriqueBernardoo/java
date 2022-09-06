package src.main.model.account;

import src.main.Account;

public class Chequing extends Account {

  private static final double OVERDRAFT_FEE = 5.50;
  private static final double OVERDRAFT_LIMIT = -200;
  private static final double INCOME_EXCEEDS = 3000;

  public Chequing(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Chequing(Chequing source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    // TODO Auto-generated method stub
    double result = super.round(super.getBalance() + amount);
    super.setBalance(result);
    // if (amount > INCOME_EXCEEDS) {
    // double tax = (amount * 15) / 100;
    // super.setBalance(super.round(result + tax));
    // } else {

    // super.setBalance(result);
    // }

  }

  @Override
  public boolean withdraw(double amount) {
    double available = super.getBalance() - amount;

    if (available < OVERDRAFT_LIMIT) {
      return false;
    } else if (amount > super.getBalance()) {
      super.setBalance(super.round(super.getBalance() - amount - OVERDRAFT_FEE));
      return true;
    } else {
      super.setBalance(super.round(super.getBalance() - amount));

    }
    return false;
  }

}
