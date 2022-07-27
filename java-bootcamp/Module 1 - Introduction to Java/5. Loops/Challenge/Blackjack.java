import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int userN1 = drawRandomCard();
        String userCard1 = cardString(userN1);
        int userN2 = drawRandomCard();
        String userCard2 = cardString(userN2);
        System.out.println("\n You get a \n" + userCard1 + "\n and a \n" + userCard2 + "");

        int handValue = Math.min(userN1, 10) + Math.min(userN2, 10);

        System.out.println("Your total is: " + handValue + "");

        int cpuN1 = drawRandomCard();
        String cpuCard1 = cardString(cpuN1);
        int cpuN2 = drawRandomCard();
        String cpuCard2 = cardString(cpuN2);
        System.out.println("\n The dealer shows \n" + cpuCard1 + "\n and has a card facing down \n" + faceDown() + "");

        int cpuValue = Math.min(cpuN1, 10) + Math.min(cpuN2, 10);

        while (true) {
            String playerAnswer = hitOrStay();

            if (playerAnswer.equals("hit")) {

                int userHit = drawRandomCard();
                String cardHit = cardString(userHit);
                System.out.println("\n You get a \n" + cardHit + "");
                if (userHit > 10) {
                    handValue += 10;
                } else {
                    handValue += userHit;
                }

                System.out.println("Your total is: " + handValue + "");
            }
            if (handValue > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
            if (playerAnswer.equals("stay")) {
                System.out.println("\nDealer's turn");
                System.out.println("\nThe dealer's cards are\n " + cpuCard1 + "\n and a \n " + cpuCard2 + "");

                if (cpuValue <= 17 && cpuValue <= 21) {

                    int cpuHit = drawRandomCard();
                    String cpuCardHit = cardString(cpuHit);
                    System.out.println("\n Dealer gets a \n " + cpuCardHit + "");
                    if (cpuHit > 10) {
                        cpuValue += 10;
                    } else {
                        cpuValue += cpuHit;
                    }
                    System.out.println("\n Dealer's total is " + cpuValue + "");
                    if (cpuValue > 21) {
                        System.out.println("Bust! Dealer loses");
                        System.exit(0);
                    }
                }

                if (handValue > cpuValue) {
                    System.out.println("Player wins!");
                    break;
                } else {
                    System.out.println("CPU wins!");
                    break;
                }
            }
        }
        scan.close();

    }

    public static int drawRandomCard() {
        return (int) (Math.random() * 13) + 1;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";

            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
            default:
                return "";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("Please write 'hit' or 'stay'");
        String answer = scan.nextLine();

        if (!answer.equals("hit") && !answer.equals("stay")) {
            System.out.println("Please write 'hit' or 'stay'");
            answer = scan.nextLine();
        }

        return answer;

    }
}
