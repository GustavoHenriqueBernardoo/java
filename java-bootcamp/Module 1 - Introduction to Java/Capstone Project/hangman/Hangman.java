import java.util.Arrays;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int round = 0;
        int misses = 0;
        char[] missesArr = new char[7];

        String randomWord = randomWord(words);
        int randomWordLength = randomWord.length();
        System.out.println("Word:" + randomWord);

        // create place holder
        char[] placeHolder = new char[randomWordLength];

        while (misses < 6) {
            System.out.println(gallows[misses]);

            printPlaceHolder(placeHolder, randomWordLength);

            System.out.println("\n");
            System.out.println("Misses: " + Arrays.toString(missesArr));
            System.out.print("\nGuess: ");round

            char guess = scan.next().charAt(0);

            Boolean checkGuess = checkGuess(guess, randomWord);

            System.out.println("\n");
            // System.out.println("Guess:" + guess);
            // System.out.println("Word:" + randomWord);
            System.out.println("before if checkGuess: " + Arrays.toString(placeHolder));

            if (checkGuess) {
                placeHolder = updatePlaceHolder(placeHolder, checkGuess, randomWord);
                System.out.println("inside if checkGuess: " + Arrays.toString(placeHolder));

            } else {
                misses++;
                missesArr[round] = guess;
            }

            System.out.println("after if checkGuess: " + Arrays.toString(placeHolder));

            round++;
        }

        scan.close();
    }

    public static String randomWord(String[] words) {
        int randomNum = (int) (Math.random() * words.length);

        return words[randomNum];
    }

    public static void printPlaceHolder(char[] placeHolder, int randomWordLength) {
        System.out.print("\n");
        System.out.print("Word:" + "\t");

        for (int i = 0; i < placeHolder.length; i++) {
            if (placeHolder[i] != '_' && placeHolder[i] != 0) {
                System.out.print(placeHolder[i] + " ");

            } else {
                placeHolder[i] = '_';
                System.out.print(placeHolder[i] + " ");
                // continue;
            }
        }
        // for (int i = 0; i < randomWordLength; i++) {
        // System.out.print("_ ");
        // }
    }

    public static Boolean checkGuess(char guess, String randomWord) {
        char[] randomWordArray = randomWord.toCharArray();

        for (int i = 0; i < randomWordArray.length; i++) {
            if (randomWordArray[i] == guess) {
                return true;
            }
        }

        return false;
    }

    public static char[] updatePlaceHolder(char[] placeHolder, Boolean checkGuess, String randomWord) {
        // int index = 0;

        // System.out.print("Word:" + "\t");
        for (int i = 0; i < randomWord.length(); i++) {
            if (checkGuess) {
                // System.out.print(randomWord.charAt(i));
                placeHolder[i] = randomWord.charAt(i);
                // System.out.println(Arrays.toString(placeHolder));
                break;
            }
        }
        return placeHolder;

    }

    public static void printMissedGuesses() {
    }

}
