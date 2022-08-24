public class Main {
    public static void main(String[] args) {

        Person person = new Person("Name", 58);

        Person person2 = new Person(person);

        System.out.println(person.equals(person2));
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());

        System.out.println(person.toString());

    }
}
