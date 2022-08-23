package src.main.models;

import java.util.Arrays;
import java.util.HashMap;

public class Game {

  HashMap<Team, Integer> scoreboard;
  public static int gameCount;
  private static final int QUEAFFLE_POINTS = 10;
  private static final int SNITCH_POINT = 150;

  public Game(Team home, Team away) {
    this.scoreboard = new HashMap<Team, Integer>();
    this.scoreboard.put(new Team(home), 0);
    this.scoreboard.put(new Team(away), 0);
    this.gameCount++;
  }

  public Integer getScore(Team team) {
    return this.scoreboard.get(team);
  }

  public void setScore(Team team, Integer score) {
    if (score == null) {
      throw new IllegalArgumentException("Score cannot be null");
    }
    this.scoreboard.put(team, score);
  }

  public Team getTeam(String name) {
    return this.scoreboard.keySet().stream()
        .filter(key -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);

  }

  public static int getQueafflePoints() {
    return QUEAFFLE_POINTS;
  }

  public static int getSnitchPoint() {
    return SNITCH_POINT;
  }

  public String getPlaceHolder(String play) {
    return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
  }

  public String replacePlaceHolder(String play, String placeHolder, String value) {
    return play.replace("<" + placeHolder + ">", value);

  }

  public void quaffleScore(Team team) {
    this.setScore(team, this.getScore(team) + QUEAFFLE_POINTS);
  }

  public void catchSnitch(Team team) {
    this.setScore(team, this.getScore(team) + SNITCH_POINT);
  }

  public Team getRandomTeam() {
    Object[] teams = scoreboard.keySet().toArray();
    return (Team) teams[random(teams.length)];

  }

  public int random(int range) {
    return (int) (Math.random() * range);
  }

  public String simulate(String play) {
    String placeholder = getPlaceHolder(play);
    Team randomTeam = getRandomTeam();
    String value = "";

    if (placeholder.equals(Team.getPositionChaser())) {
      quaffleScore(randomTeam);
      value = randomTeam.getChaser()[random(randomTeam.getChaser().length)];
    } else if (placeholder.equals(Team.getPositionSeeker())) {
      catchSnitch(randomTeam);
      value = randomTeam.getSeeker();
    } else if (placeholder.equals(Team.getPositionKeeper())) {
      value = randomTeam.getKeeper();
    }

    return replacePlaceHolder(play, placeholder, value);
  }

}
