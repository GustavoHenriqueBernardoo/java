package src.main.model.account;

import src.main.Account;

public class Chequing extends Account {

  public Chequing(String id, String name, double balance) {
    super(id, name, balance);
  }

  public Chequing(Chequing source) {
    super(source);
  }
}
