import java.util.Arrays;

import javax.sound.midi.Soundbank;

public class Person {

  // fields
  private String name;
  private String nationality;
  private String dateOfBirth;
  private String[] passport;
  private int seatNumber;

  // constructor
  public Person(String name, String nationality, String dateOfBirth, int seatNumber) {
    this.name = name;
    this.nationality = nationality;
    this.dateOfBirth = dateOfBirth;
    this.passport = new String[3];
    this.seatNumber = seatNumber;
  }

  // copy constructor
  public Person(Person source) {
    // source means the obj you wanna copy, the source obj
    this.name = source.name;
    this.nationality = source.nationality;
    this.dateOfBirth = source.dateOfBirth;
    this.passport = Arrays.copyOf(source.passport, source.passport.length);
    this.seatNumber = source.seatNumber;
  }

  // getters
  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String[] getPassport() {
    return Arrays.copyOf(passport, passport.length);
  }

  public int getSeatNumber() {
    return seatNumber;
  }

  // setters
  public void setName(String name) {
    this.name = name;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setPassport() {
    this.passport = new String[] { this.name, this.nationality, this.dateOfBirth };
  }

  public void setSeatNumber(int seatNumber) {
    this.seatNumber = seatNumber;
  }

  public boolean applyPassport() {
    int randomNum = (int) (Math.random() * 2) + 1;
    if (randomNum == 1) {
      return true;
    }

    return false;
  }

  public void chooseSeat() {
    int randomNum = (int) (Math.random() * 11) + 1;
    this.seatNumber = randomNum;
  }

  public String toString() {
    return "Name: " + this.name + "\n" + "Nationality: " +
        this.nationality + "\n" + "Date of Birth: " +
        this.dateOfBirth + "\n" + "Seat Number: " +
        this.seatNumber + "\n" + "Passport: " +
        Arrays.toString(this.passport) + "\n";
  }

  // private String name;
  // private String nationality;
  // private String dateOfBirth;
  // private String[] passport;
  // private int seatNumber;

  // // Constructor
  // public Person(String name, String nationality, String dateOfBirth, int
  // seatNumber) {
  // this.name = name;
  // this.nationality = nationality;
  // this.dateOfBirth = dateOfBirth;
  // this.seatNumber = seatNumber;
  // this.passport = new String[3];
  // }

  // // Copy Constructor
  // public Person(Person source) {
  // this.name = source.name;
  // this.nationality = source.nationality;
  // this.dateOfBirth = source.dateOfBirth;
  // this.passport = Arrays.copyOf(source.passport, source.passport.length);
  // this.seatNumber = source.seatNumber;
  // }

  // // Getters

  // public String getName() {
  // return this.name;
  // }

  // public String getNationality() {
  // return this.nationality;
  // }

  // public String getDateOfBirth() {
  // return this.dateOfBirth;
  // }

  // public int getSeatNumber() {
  // return this.seatNumber;
  // }

  // public String[] getPassport() {
  // return Arrays.copyOf(this.passport, this.passport.length);
  // }

  // // Setters

  // public void setName(String name) {
  // this.name = name;
  // }

  // public void setNationality(String nationality) {
  // this.nationality = nationality;
  // }

  // public void setDateOfBirth(String dateOfBirth) {
  // this.dateOfBirth = dateOfBirth;
  // }

  // public void setSeatNumber(int seatNumber) {
  // this.seatNumber = seatNumber;
  // }

  // public void setPassport() {
  // this.passport = new String[] { this.name, this.nationality, this.dateOfBirth
  // };
  // }

  // public boolean applyPassport() {
  // int random = (int) (Math.random() * 2) + 1;
  // if (random == 1) {
  // return true;
  // } else {
  // return false;
  // }
  // }

  // public void chooseSeat() {
  // this.seatNumber = (int) (Math.random() * 11) + 1;
  // }

  // // The toString method(function) is called automatically when you print an
  // // Object in java
  // public String toString() {
  // return "Name: " + this.name + "\n"
  // + "Nationality: " + this.nationality + "\n"
  // + "Date of Birth: " + this.dateOfBirth + "\n"
  // + "Seat Number: " + this.seatNumber + "\n"
  // + "Passport: " + Arrays.toString(this.passport) + "\n";
  // }

}