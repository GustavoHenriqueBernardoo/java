public class Variables{
  public static void main(String[] args) {
    String sentence = "Number of passengers: ";
    int passengers = 20;
    int busTickets = passengers;
    busTickets += 10;
    busTickets -= 25;
    System.out.println(sentence + passengers);
  }
}