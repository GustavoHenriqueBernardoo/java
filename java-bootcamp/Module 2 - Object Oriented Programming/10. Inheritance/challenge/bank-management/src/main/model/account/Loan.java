package src.main.model.account;

import src.main.Account;

public class Loan extends Account {

  // private static final double INTEREST_RATE = 36;

  private static final double INTEREST_RATE = 0.02;
  private static final double MAX_DEBT = 10000;

  public Loan(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Loan(Loan source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    super.setBalance(super.round(super.getBalance() - amount));

  }

  @Override
  public boolean withdraw(double amount) {
    double interestRate = super.round((amount * INTEREST_RATE));
    double total = super.round(super.getBalance() + amount + interestRate);

    if (!(total > MAX_DEBT)) {
      super.setBalance(total);
      return true;
    } else {
      return false;
    }
  }

}
