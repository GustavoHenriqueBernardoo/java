package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import src.main.Main;

public class checkoutTest {
  @Test

  public void subtotalIsValid() {
    assertEquals(19.2, Main.getSubtotal());
  }

  @Test
  public void taxIsValid() {
    assertEquals(3.9, Main.getTax(30));
  }

  @Test
  public void totalIsValid() {
    assertEquals(113, Main.getTotal(100, 13));
  }

}
