import java.util.Arrays;

public class Airline {

  // fields
  private Person seats[];

  // constructor
  public Airline() {
    this.seats = new Person[11];
  }

  // getters
  public Person getPerson(int index) {
    return new Person(this.seats[index]);
  }

  // setters
  public void setPerson(Person person) {
    this.seats[person.getSeatNumber() - 1] = new Person(person);
  }

  public void createReservation(Person person) {

    while (this.seats[person.getSeatNumber() - 1] != null) {
      System.out.println("\n" + person.getName() + ", seat: " + person.getSeatNumber()
          + " is already taken. Please choose another one.\n");

      person.chooseSeat();
    }
    this.seats[person.getSeatNumber() - 1] = new Person(person);
    System.out.println("println: Thank you " + person.getName() + " for flying with Java airlines. Your seat number is "
        + person.getSeatNumber() + ".\n");
  }

  public String toString() {
    String temp = "";
    temp += "****************** RESERVATIONS COMPLETE! ******************";
    for (int i = 0; i < this.seats.length; i++) {
      temp += "\n \n";
      // checking if the current element from the seats arrays is not null, if is null
      // we can't use this.seats[i].toString() because will crash the java

      // because you cannot access toString from a null
      if (this.seats[i] != null) {
        temp += this.seats[i].toString();

      } else {
        int newI = i + 1;
        temp += "Seat " + newI + " is empty";
      }
    }
    return temp;
  }
}
