public class Exams {
    public static void main(String[] args) {

        System.out.println("It's time to take your 5th year exams. Please, take your seats.\n");
        // Task 1: Create an array that stores 5 students: "Harry", "Neville", "Ron",
        // "Hermione", "Seamus"
        String[] students = { "Harry", "Neville", "Ron", "Hermione", "Seamus" };
        // Task 2: Assign each student a seat according to their index in the array.
        // print: " <student at index 0> ", you will take seat 0.
        System.out.println("student: " + students[0] + " Will take seat 0");
        System.out.println(students[1]);
        System.out.println(students[2]);
        System.out.println(students[3]);
        System.out.println(students[4]);
    }
}