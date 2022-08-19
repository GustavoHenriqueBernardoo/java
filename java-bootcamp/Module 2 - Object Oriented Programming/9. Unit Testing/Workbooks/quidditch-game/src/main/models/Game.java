package src.main.models;

import java.util.HashMap;

public class Game {

  HashMap<Team, Integer> scoreboard;

  public Game(Team home, Team away) {
    this.scoreboard = new HashMap<Team, Integer>();
    this.scoreboard.put(new Team(home), 0);
    this.scoreboard.put(new Team(away), 0);
  }

  public Integer getScore(Team team) {
    return this.scoreboard.get(team);
  }

  public void setScore(Team team, Integer score) {
    this.scoreboard.put(team, score);
  }

  public Team getTeam(String name) {
    return null;
  }
}
