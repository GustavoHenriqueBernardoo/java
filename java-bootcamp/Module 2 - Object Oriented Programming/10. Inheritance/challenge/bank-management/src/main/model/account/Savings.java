package src.main.model.account;

import src.main.Account;

public class Savings extends Account {

  public Savings(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Savings(Savings source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean withdraw(double amount) {
    double fee = 5.00;
    this.setBalance((this.getBalance() - amount) - fee);
    return false;
  }

}
