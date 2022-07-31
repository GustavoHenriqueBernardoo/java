import java.util.Arrays;

public class Main {

    // public static void main(String[] args) {
    // Person person = new Person("Gustavo Bernardo", "Brazil", "21/03/1994", 42);
    // person.chooseSeat();
    // ;
    // System.out.println("\nName: " + person.getName() + "\n" + "Nationality: " +
    // person.getNationality() + "\n"
    // + "Date of Birth: " + person.getDateOfBirth() + "\n" + "Seat Number: " +
    // person.getSeatNumber() + "\n");

    // if (person.applyPassport()) {
    // System.out.println("\nCongratulations " + person.getName() + ". Your passport
    // was aproved");
    // } else {
    // System.out.println("\nWe're sorry " + person.getName() + ". We cannot process
    // your application.");
    // }

    // }

    public static void main(String[] args) {
        String[] passport = { "person.getName()", "person.getNationality()" };

        Person person = new Person("Gustavo Bernardo", "Brazil", "11/11/11", passport, 55);

        if (person.applyPassport() == true) {

        }

        person.setPassport();

        System.out.println("Name: " + person.getName() + "\n" +
                "Nationality: " + person.getNationality() + "\n" +
                "Date of Birth: " + person.getDateOfBirth() + "\n" +
                "Seat Number: " + person.getSeatNumber() + "\n" + "Passport: " +
                Arrays.toString(person.getPassport()) + "\n");
    }

}