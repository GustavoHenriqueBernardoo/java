package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.PrinterLocation;

import src.main.models.Game;
import src.main.models.Team;

public class Main {

        static final String TEAMS_FILE = "src/main/teams.txt";
        static final String PLAYS_FILE = "src/main/plays.txt";

        static Game game;

        public static void main(String[] args) {
                try {
                        String[][] data = getData();
                        game = new Game(
                                        new Team(data[0][0], data[0][1], data[0][2],
                                                        new String[] { data[0][3], data[0][4], data[0][5] }),
                                        new Team(data[1][0], data[1][1], data[1][2],
                                                        new String[] { data[1][3], data[1][4], data[1][5] }));
                        startGame();
                        printResult();
                } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                }

        }

        public static String[][] getData() throws FileNotFoundException {
                FileInputStream fis = new FileInputStream(TEAMS_FILE);
                Scanner scanDoc = new Scanner(fis);

                String[][] data = new String[2][6];

                for (int i = 0; scanDoc.hasNextLine(); i++) {
                        String line = scanDoc.nextLine();
                        String[] item = line.split(",");
                        for (int j = 0; j < item.length; j++) {
                                data[i][j] = item[j];
                        }
                }
                scanDoc.close();
                return data;
        }

        public static void startGame() throws FileNotFoundException {
                FileInputStream fis = new FileInputStream(PLAYS_FILE);
                Scanner scanFile = new Scanner(fis);

                String[][] data = getData();

                while (scanFile.hasNextLine()) {
                        String play = scanFile.nextLine();
                        String simulate = game.simulate(play);
                        System.out.println("\n" + simulate + "\n");
                        try {
                                wait(3);
                        } catch (InterruptedException e) {
                                System.out.println(e.getMessage());
                        }
                }

                scanFile.close();
        }

        public static void printResult() {
                Team gryff = game.getTeam("GRYFFINDOR");
                Team slyth = game.getTeam("SLYTHERIN");
                int home = game.getScore(gryff);
                int away = game.getScore(slyth);

                System.out.println("\nGRYFFINDOR: " + home + " X SLYTHERIN: " + away);

                if (home > away) {
                        System.out.println("\n" + gryff.getHouse() + " WINS!");
                } else {
                        System.out.println("\n" + slyth.getHouse() + " WINS!");

                }
        }

        public static void wait(int sec) throws InterruptedException {
                TimeUnit.SECONDS.sleep(sec);
        }
        /**
         * Function name: wait
         * 
         * @param sec
         * 
         *            Inside the function:
         *            1. Make the code sleep for X seconds.
         */

}
