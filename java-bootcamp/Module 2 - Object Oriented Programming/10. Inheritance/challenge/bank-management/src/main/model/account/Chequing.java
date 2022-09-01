package src.main.model.account;

import src.main.Account;

public class Chequing extends Account {

  public Chequing(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Chequing(Chequing source) {
    super(source);
  }

  @Override
  public void deposit(double amount) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean withdraw(double amount) {
    double overdraft = amount - this.getBalance();
    // if (!(overdraft < 200)) {
    // this.setBalance(super.round(this.getBalance() - amount));
    // return true;
    // }

    if (amount > this.getBalance() && overdraft < 200) {
      this.setBalance(super.round(this.getBalance() - amount) - 5.50);

      return true;
    } else if (!(overdraft >= 200)) {
      this.setBalance(super.round(this.getBalance() - amount));
      return true;
    } else {
      // this.setBalance(super.round(this.getBalance() - amount));

    }

    // } else if (!(overdraft < 200)) {
    // this.setBalance(super.round(this.getBalance() - amount));
    // }

    return false;
  }

}
