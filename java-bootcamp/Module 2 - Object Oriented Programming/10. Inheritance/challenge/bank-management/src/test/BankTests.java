package src.test;

import org.junit.Before;

import src.main.model.Bank;

public class BankTests {

  Bank bank;

  @Before
  public void setup() {
    bank = new Bank();
  }
}
