package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
  private String name;
  private String dateOfBirth;
  private String phoneNumber;
  private int age;

  // Constructor
  public Contact(String name, String dateOfBirth, String phoneNumber) throws ParseException {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.age = toAge(dateOfBirth);

  }

  // copy Constructor
  public Contact(Contact source) {
    this.name = source.name;
    this.phoneNumber = source.phoneNumber;
    this.dateOfBirth = source.dateOfBirth;
    this.age = source.age;

  }

  // getters
  public String getName() {
    return name;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getAge() {
    return age;
  }

  // setters

  public void setName(String name) {
    this.name = name;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setDateOfBirth(String dateOfBirth) throws ParseException {
    this.dateOfBirth = dateOfBirth;
    setAge(toAge(dateOfBirth));
  }

  private void setAge(int age) throws ParseException {
    this.age = toAge(dateOfBirth);
  }

  public int toAge(String dateOfBirth) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter.setLenient(false);

    Date stringToDate = formatter.parse(dateOfBirth); // convert String to Date
    long dateToMillis = stringToDate.getTime(); // getTime() returns the number of milliseconds since 1970

    long diff = new Date().getTime() - dateToMillis; // new Date get the current time

    // TimeUnit class converts from milliseconds to days
    int age = (int) TimeUnit.MILLISECONDS.toDays(diff) / 365; // then divide by 365 to get the age in years

    return age;
  }

  public String toString() {
    return "Name: " + this.name + "\n" +

        "Phone number: " + this.phoneNumber + "\n" +

        "Birth Date: " + this.dateOfBirth + "\n" +

        "Age: " + this.age + " year old\n";
  }

}
