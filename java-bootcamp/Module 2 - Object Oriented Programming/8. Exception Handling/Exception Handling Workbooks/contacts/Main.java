import java.text.ParseException;

import models.Contact;

public class Main {
    public static void main(String[] args) {

        try {
            Contact contact = new Contact("Gustavo", "03/21/1994", "+55 (19) 9999-9999");

            // System.out.println(contact.toAge("03/21/1990"));

            Contact contact2 = new Contact(contact);

            contact2.setName("I am a new contact");
            contact2.setDateOfBirth("01/01/1998");

            System.out.println(contact);
            System.out.println(contact2);

        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Process completed");
        }

        // String dateOfBirth = "03-21-1994";
        // SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        // String newDate = formatter.format(new Date());

        // Date date;
        // try {
        // Date currentDate = formatter.parse(newDate);
        // long currentDateInt = currentDate.getTime();

        // date = formatter.parse(dateOfBirth);
        // long dateInt = date.getTime();

        // long milliseconds = currentDateInt - dateInt;

        // long days = TimeUnit.MILLISECONDS.toDays(milliseconds);

        // System.out.println(days / 365);
        // } catch (ParseException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) add b) remove a contact
     * c) exit.
     * • case a: ask for the name, phone number and birthDate.
     * • case b: ask who they'd like to remove.
     * • case c: break the loop.
     * • 3. close Scanner.
     */

    /**
     * Name: loadContacts
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads contacts from <fileName>;
     *                               • 2. From the manager object, it adds all
     *                               contacts to the contacts list.
     *                               Hint: use scan.next to grab the next String
     *                               separated by white space.
     */

}
