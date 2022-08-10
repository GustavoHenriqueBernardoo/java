package models;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;

public class ContactManager {
  // fields
  ArrayList<Contact> contacts;

  // Constructor
  public ContactManager() {
    this.contacts = new ArrayList<Contact>();
  }

  // getters
  public Contact getContact(int index) {
    return new Contact(contacts.get(index));
  }

  // setters
  public void setContact(int index, Contact contact) {
    this.contacts.set(index, new Contact(contact));
  }

  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  public void removeContact(String contactName) {

    if (this.contacts.size() <= 0) {
      throw new IllegalStateException("The contact Manager is empty, there's nothing to remove");
    }

    for (int i = 0; i < this.contacts.size(); i++) {
      if (this.contacts.get(i).getName().equalsIgnoreCase(contactName)) {
        this.contacts.remove(i);
      }
    }
  }

  public String toString() {
    String temp = "";
    for (int i = 0; i < this.contacts.size(); i++) {
      temp += "\n" + this.contacts.get(i).toString();
      temp += "\n\n";
    }

    return temp;
  }
}
