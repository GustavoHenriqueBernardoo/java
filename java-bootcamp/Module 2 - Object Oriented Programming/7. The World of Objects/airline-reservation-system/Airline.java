import java.util.Arrays;

public class Airline {

  // create an seats array from the Person Object
  private Person[] seats;

  // Constructor
  public Airline() {
    this.seats = new Person[11];
  }

  // getters
  public Person getPerson(int index) {
    return new Person(this.seats[index]);
  }

  // setters
  public void setPerson(Person person, int index) {
    this.seats[person.getSeatNumber()] = new Person(person);
  }

  public void createReservation(Person person) {

    while (seats[person.getSeatNumber() - 1] != null) {
      System.out.println(
          "\n" + person.getName() + ", seat: " + person.getSeatNumber()
              + " is already taken. Please choose another one.\n");
      person.chooseSeat();
    }

    int index = person.getSeatNumber() - 1;
    seats[index] = new Person(person);

    System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is "
        + person.getSeatNumber() + ".\n");
  }

  public String toString() {
    String temp = "";

    System.out.println(Arrays.toString(seats));

    for (int i = 0; i < seats.length; i++) {
      temp = "Name: ";
    }

    return temp;
  }

}
