package src.main.model.account;

import src.main.Account;

public class Savings extends Account {

  private static final double WITHDRAW_CHARGE = 5.00;

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
    super.setBalance(super.getBalance() - amount - WITHDRAW_CHARGE);
    return false;
  }

  @Override
  public Account clone() {
    return new Savings(this);
  }

}
