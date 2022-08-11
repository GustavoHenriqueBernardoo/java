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

            System.out.println("Contact Loaded");

            manageContacts();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void loadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanDocument = new Scanner(fis);

        while (scanDocument.hasNextLine()) {
            try {
                Contact contact = new Contact(scanDocument.next(), scanDocument.next(), scanDocument.next());
                contactManager.addContact(contact);

            } catch (ParseException e) { // Parse Exception
                System.out.println(e.getMessage());

            }
        }

        scanDocument.close();
    }

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
                char option = scan.next().charAt(0);
                // throw an next line because of the scan.next
                scan.nextLine();
                if (option == 'a') {
                    // pick up name.
                    System.out.println("\tName: ");
                    String name = scan.nextLine();

                    // pick up number.
                    System.out.println("\tPhone Number: ");
                    String phoneNumber = scan.nextLine();

                    // pick up birth date.
                    System.out.println("\tBirth Date: ");
                    String dateOfBirth = scan.nextLine();

                    if (name.isBlank() || name == null || phoneNumber.isEmpty() || phoneNumber == null
                            || phoneNumber.length() < 5 || dateOfBirth.isEmpty() || dateOfBirth == null) {
                        System.out.println("\nThe input you provided is not valid. Registration failed.\n");
                        continue;
                    }

                    Contact newContact = new Contact(name, phoneNumber, dateOfBirth);
                    contactManager.addContact(newContact);

                    System.out.println("\n\nUPDATED CONTACTS \n\n ");
                    System.out.println(contactManager);

                }
                if (option == 'b') {
                    System.out.println("\nWho would you like to remove?");
                    String name = scan.nextLine();

                    contactManager.removeContact(name);

                    System.out.println("\n\nUPDATED CONTACTS \n\n ");
                    System.out.println(contactManager);
                }
                if (option == 'c') {
                    break;
                }
            }
        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\n\nProcess Complete \n\n ");
            System.out.println("\n\nHeres' how your contact are: ");

            System.out.println(contactManager);
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