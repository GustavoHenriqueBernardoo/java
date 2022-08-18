package src.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.main.models.Team;

public class TeamTest {
  @Test
  public void hasNullTest() {
    String[] chasers = new String[] { null, "Ginny", "Katie" };
    assertTrue(Team.hasNull(chasers));
  }

  @Test
  public void hasBlankTest() {
    String[] chasers = { " ", "Ginny", "Katie" };
    assertTrue(Team.hasBlank(chasers));
  }
}
