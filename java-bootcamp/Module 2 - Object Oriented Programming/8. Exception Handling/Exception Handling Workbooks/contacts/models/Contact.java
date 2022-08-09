package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * Research how to create an object of the SimpleDateFormat class.

Use the SimpleDateFormat object to parse() a Date from the birthDate String.

Assume the birthDate follows the MM/dd/yyyy format.
Get the current time as a Date object.

Find a method from the Date class that returns milliseconds since 1970 from each date.

Get the difference between both time units. This difference is the person's age in milliseconds.

Research how to use the TimeUnit class to convert from milliseconds to days. Then, divide by 365 to get the years.

Typecast the result to int and update the age field.
 */

public class Contact {
  private String name;
  private int age;
  private int dateOfBirth;
  private int phoneNumber;

  public Contact(String name, String dateOfBirth, int phoneNumber) {
    System.out.println(dateOfBirth);
    this.name = name;
    this.dateOfBirth = calculateAge(dateOfBirth);
    this.phoneNumber = phoneNumber;
  }

  public int calculateAge(String dateOfBirth) {
    // String dateOfBirth = "03-21-1994";
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    String newDate = formatter.format(new Date());

    try {
      Date currentDate = formatter.parse(newDate);
      long currentDateInt = currentDate.getTime();

      Date date = formatter.parse(dateOfBirth);
      long dateInt = date.getTime();

      long milliseconds = currentDateInt - dateInt;

      int days = (int) TimeUnit.MILLISECONDS.toDays(milliseconds);

      System.out.println(days / 365);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }

    return 0;
  }

}
