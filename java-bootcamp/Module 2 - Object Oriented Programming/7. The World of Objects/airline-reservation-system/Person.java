import java.util.Arrays;

public class Person {

  private String name;
  private String nationality;
  private String dateOfBirth;
  private String[] passport;
  private int seatNumber;

  // Constructor
  public Person(String name, String nationality, String dateOfBirth, String[] passport, int seatNumber) {
    this.name = name;
    this.nationality = nationality;
    this.dateOfBirth = dateOfBirth;
    this.seatNumber = seatNumber;
    this.passport = new String[3];
  }

  // Copy Constructor
  public Person(Person source) {
    this.name = source.name;
    this.nationality = source.nationality;
    this.dateOfBirth = source.dateOfBirth;
    this.passport = Arrays.copyOf(source.passport, source.passport.length);
    this.seatNumber = source.seatNumber;
  }

  // Getters

  public String getName() {
    return this.name;
  }

  public String getNationality() {
    return this.nationality;
  }

  public String getDateOfBirth() {
    return this.dateOfBirth;
  }

  public int getSeatNumber() {
    return this.seatNumber;
  }

  public String[] getPassport() {
    return Arrays.copyOf(this.passport, this.passport.length);
  }

  // Setters

  public void setName(String name) {
    this.name = name;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setSeatNumber(int seatNumber) {
    this.seatNumber = seatNumber;
  }

  public void setPassport() {
    this.passport = new String[] { this.name, this.nationality, this.dateOfBirth };
  }

  public boolean applyPassport() {
    int random = (int) (Math.random() * 2) + 1;
    if (random == 1) {
      return true;
    } else {
      return false;
    }
  }

  public void chooseSeat() {
    this.seatNumber = (int) (Math.random() * 11) + 1;
  }

}