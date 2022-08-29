package src.main.model.account;

import src.main.Account;

public class Loan extends Account {

  public Loan(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Loan(Loan source) {
    super(source);
  }

}
