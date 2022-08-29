package src.main.model.account;

import src.main.Account;

public class Savings extends Account {

  public Savings(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Savings(Savings source) {
    super(source);
  }

}
