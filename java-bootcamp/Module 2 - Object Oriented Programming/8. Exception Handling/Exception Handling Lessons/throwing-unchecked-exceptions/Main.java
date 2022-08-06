import Models.Store;
import Models.Employee;

public class Main {
    public static void main(String[] args) {
        Employee stocker = new Employee("Paul", "Stocker");
        Employee assisManager = new Employee("Nicholas", "Assistant manager");
        Employee manager = new Employee("Demean", "Manager");

        Store store = new Store();

        store.setEmployees(0, stocker);
        store.setEmployees(1, assisManager);
        store.setEmployees(2, manager);

        System.out.println(store);
        store.open();

    }
}
