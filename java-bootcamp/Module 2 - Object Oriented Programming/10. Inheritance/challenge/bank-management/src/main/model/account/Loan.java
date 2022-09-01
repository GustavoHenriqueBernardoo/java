package src.main.model.account;

import src.main.Account;

public class Loan extends Account {

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
    return false;
  }

}
