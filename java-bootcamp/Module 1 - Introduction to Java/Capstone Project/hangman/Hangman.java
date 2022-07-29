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
                    "/|\\  |\n" +
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

        int misses = 0;
        char[] missesArr = new char[6];

        String randomWord = randomWord(words);
        int randomWordLength = randomWord.length();
        System.out.println("Word:" + randomWord);

        // create place holder
        char[] placeHolder = new char[randomWordLength];

        while (misses < 6) {
            // Print the gallow draw
            System.out.println(gallows[misses]);

            // Print the place holder to the word
            System.out.print("\n");
            System.out.print("Word:" + "\t");
            printPlaceHolder(placeHolder, randomWordLength);

            // Print amount of wrong guesses
            System.out.println("\n");
            System.out.print("Misses:" + "\t");
            printMissedGuesses(missesArr);

            // The user input: Guess
            System.out.print("\nGuess: ");
            char guess = scan.next().charAt(0);
            System.out.println("\n");

            // Check if the guess is correct
            Boolean checkGuess = checkGuess(guess, randomWord);

            // If the guess is correct, update place holder
            if (checkGuess) {
                updatePlaceHolder(placeHolder, guess, randomWord);

            }

            // Check if the a wrong guess was entered already, if yes, just continue if not,
            // continue misses count
            if (contains(guess, missesArr)) {
                continue;
            } else {
                missesArr[misses] = guess;

                misses++;
            }

            // Check if the two arrays content are equal to end the game
            // Arrays.equals compare all the content of it and return if is true or not
            if (Arrays.equals(placeHolder, randomWord.toCharArray())) {
                // word:
                System.out.println("Word: " + randomWord + "\n");

                // good work
                System.out.println("Good Work");

                // break the game
                System.exit(0);
            }

            // If misses is equal to 6, end the game, the user lost the game
            if (misses == 6) {
                System.out.println(gallows[misses] + "\n");
                System.out.println("RIP!" + "\n");
                System.out.println("The word was: " + randomWord);
            }

        }

        scan.close();
    }

    // create a random number to get a random word
    public static String randomWord(String[] words) {
        int randomNum = (int) (Math.random() * words.length);

        return words[randomNum];
    }

    // checkGuess return true of false
    public static Boolean checkGuess(char guess, String randomWord) {
        // convert the String randomWord to a char Array to loop through it
        char[] randomWordArray = randomWord.toCharArray();

        for (int i = 0; i < randomWordArray.length; i++) {
            // if the letter is equal the guess return true
            if (randomWordArray[i] == guess) {
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceHolder(char[] placeHolder, char guess, String randomWord) {
        for (int i = 0; i < randomWord.length(); i++) {
            if (guess == randomWord.charAt(i)) {
                // update the place holder
                placeHolder[i] = guess;
            }
        }

    }

    public static void printPlaceHolder(char[] placeHolder, int randomWordLength) {

        for (int i = 0; i < placeHolder.length; i++) {
            // Check if the place holder is not a dash or an empty value
            // important to remember is to check if a char array has a empty value, has to
            // check for 0, not null or ' '
            if (placeHolder[i] != '_' && placeHolder[i] != 0) {
                System.out.print(placeHolder[i] + " ");

            } else {
                // if the place holder is empty fill it with a dash
                placeHolder[i] = '_';
                System.out.print(placeHolder[i] + " ");
            }
        }
    }

    public static void printMissedGuesses(char[] missesArr) {
        for (int i = 0; i < missesArr.length; i++) {
            System.out.print(missesArr[i]);
        }

    }

    // Stack overflow method to check if an array contains a char value
    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

}
