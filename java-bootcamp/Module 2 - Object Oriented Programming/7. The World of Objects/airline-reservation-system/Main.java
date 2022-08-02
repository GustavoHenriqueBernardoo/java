import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[] {
                new Person("Cleopatra", "Egypt", "69 BC", 1),
                new Person("Alexander the Great", "Macedon", "356 BC", 2),
                new Person("Julius Caesar", "Rome", "100 BC", 3),
                new Person("Hannibal", "Carthage", "247 BC", 4),
                new Person("Confucius", "China", "551 BC", 5),
                new Person("Pericles", "Greece", "429 BC", 6),
                new Person("Spartacus", "Thrace", "111 BC", 7),
                new Person("Marcus Aurelius", "Rome", "121 AD", 8),
                new Person("Leonidas", "Greece", "540 BC", 9),
                new Person("Sun Tzu", "China", "544 BC", 10),
                new Person("Hammurabi", "Babylon", "1750 BC", 10),
        };

        Airline airline = new Airline();
        for (int i = 0; i < people.length; i++) {

            // airline.setPerson(people[i], i);
            airline.createReservation(people[i]);
            airline.toString();
        }

    }
    // public static void main(String[] args) {
    // Person[] people = new Person[] { new Person("Cleopatra", "Egypt", "69 BC",
    // 1),
    // new Person("Alexander the Great", "Macedon", "356 BC", 2),
    // new Person("Julius Caesar", "Rome", "100 BC", 3),
    // new Person("Hannibal", "Carthage", "247 BC", 4),
    // new Person("Confucius", "China", "551 BC", 5),
    // new Person("Pericles", "Greece", "429 BC", 6),
    // new Person("Spartacus", "Thrace", "111 BC", 7),
    // new Person("Marcus Aurelius", "Rome", "121 AD", 8),
    // new Person("Leonidas", "Greece", "540 BC", 9),
    // new Person("Sun Tzu", "China", "544 BC", 10),
    // new Person("Hammurabi", "Babylon", "1750 BC", 11),
    // };
    // Airline airline = new Airline();

    // for (int i = 0; i < people.length; i++) {
    // airline.setPerson(people[i], i);
    // }

    // System.out.println(airline.getPerson(1));
    // System.out.println(airline.getPerson(5));
    // System.out.println(airline.getPerson(10));
    // }

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

    // public static void main(String[] args) {
    // String[] passport = { "person.getName()", "person.getNationality()" };

    // Person person = new Person("Gustavo Bernardo", "Brazil", "11/11/11",
    // passport, 55);

    // if (person.applyPassport() == true) {

    // }

    // person.setPassport();

    // // System.out.println(person);

    // Airline airline = new Airline();

    // System.out.println(airline.getPerson(0));
    // }

}