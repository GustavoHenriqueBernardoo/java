import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {
    static ContactManager contactManager = new ContactManager();

    public static void main(String[] args) {

        try {
            loadContacts("contacts.txt");

            System.out.println(contactManager);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) {
            try {
                Contact contact = new Contact(scan.next(), scan.next(), scan.next());
                contactManager.addContact(contact);

            } catch (ParseException e) { // Parse Exception
                System.out.println(e.getMessage());

            }
        }

        scan.close();
    }

}

// try {

// Contact contact = new Contact("name", "dateOfBirth", "phoneNumber");

// Contact[] contacts = new Contact[] {
// new Contact("Ryan", "11/11/1992", "6135012424"),
// new Contact("Gio", "11/11/1993", "6477092344"),
// new Contact("Thomas", "11/11/1994", "8192256979")
// };

// ContactManager contactManager = new ContactManager();

// for (int i = 0; i < contacts.length; i++) {
// contactManager.addContact(contacts[i]);
// }

// contactManager.removeContact("Gio");

// contactManager.addContact(new Contact("Gustavo", "03/21/1994", "9981555"));

// contactManager.removeContact("Ryan");
// contactManager.removeContact("Thomas");
// contactManager.removeContact("Gustavo");

// System.out.println(contactManager);

// } catch (ParseException e) {
// // TODO: handle exception
// System.out.println(e.getMessage());
// } finally {
// System.out.println("Process completed");
// }