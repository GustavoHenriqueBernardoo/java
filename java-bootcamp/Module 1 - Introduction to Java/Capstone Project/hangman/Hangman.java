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

    public static String randomWord(String[] words) {
        int randomNum = (int) (Math.random() * words.length);

        return words[randomNum];
    }

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

    public static void printGallows(String[] gallows) {

    }

    public static void printPlaceHolder(String[] words, String randomWord) {
        String random = randomWord(words);
        int wordLength = random.length();
        System.out.print("\n");
        System.out.print("Word:" + "\t");
        for (int i = 0; i < wordLength; i++) {
            System.out.print("_ ");
        }
    }

    public static Boolean checkGuess(char guess, String randomWord) {
        int index = 0;

        if (guess == randomWord.charAt(index)) {
            index++;
            return true;
        }
        return false;
    }

    public static void updatePlaceHolder(char[] placeHolder, Boolean checkGuess, String randomWord) {
        // int index = 0;

        System.out.print("Word:" + "\t");
        for (int i = 0; i < randomWord.length(); i++) {
            if (checkGuess) {
                System.out.print(randomWord.charAt(i));
                break;
            } else {
                System.out.print("_ ");

            }

        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int round = 0;
        String randomWord = randomWord(words);
        System.out.println("Word:" + randomWord);

        // create place holder
        char[] placeHolder = new char[randomWord.length()];

        System.out.println(Arrays.toString(placeHolder));

        while (round < 6) {
            System.out.println(gallows[0]);
            printPlaceHolder(words, randomWord);
            System.out.println("\n");
            System.out.println("Misses: ");
            System.out.print("\nGuess: ");
            char guess = scan.next().charAt(0);

            Boolean checkGuess = checkGuess(guess, randomWord);

            System.out.println("\n");
            // System.out.println("Guess:" + guess);
            // System.out.println("Word:" + randomWord);

            updatePlaceHolder(placeHolder, checkGuess, randomWord);

            round++;
        }

        scan.close();
    }

}
