package src.main.model.account;

import src.main.Account;

public class Loan extends Account {

  // private static final double INTEREST_RATE = 36;

  private static final double DEBT_EXCEEDS = 10.000;

  public Loan(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Loan(Loan source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean withdraw(double amount) {
    double interestRate = (amount * 2) / 100;
    double total = super.round(super.getBalance() + amount + interestRate);
    if (checkDebt(total)) {
      super.setBalance(total);
      return true;
    } else {
      return false;

    }
  }

  public boolean checkDebt(double total) {
    if (!(total > DEBT_EXCEEDS)) {
      return true;
    } else {
      return false;
    }
  }

}
