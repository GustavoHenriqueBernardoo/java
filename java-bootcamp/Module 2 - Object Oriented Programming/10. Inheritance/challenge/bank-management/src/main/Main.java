package src.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.print.event.PrintEvent;

import src.main.model.Bank;
import src.main.model.Transaction;
import src.main.model.account.Chequing;
import src.main.model.account.Loan;
import src.main.model.account.Savings;

public class Main {

    static String ACCOUNTS_FILE = "src/main/data/accounts.txt";
    static String TRANSACTIONS_FILE = "src/main/data/transactions.txt";

    static Bank bank = new Bank();

    public static void main(String[] args) {

        try {
            Account account = createObject(
                    new String[] { "Chequing", "f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", "1524.51" });

            System.out.println();

            returnAccounts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Account createObject(String[] values) throws Exception {

        return (Account) Class.forName("src.main.model.account." + values[0])
                .getConstructor(String.class, String.class, double.class)
                .newInstance(values[1], values[2], Double.parseDouble(values[3]));

    }

    public static ArrayList<Account> returnAccounts() throws FileNotFoundException {
        ArrayList<Account> accounts = new ArrayList<>();

        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner scan = new Scanner(fis);
        for (int i = 0; scan.hasNextLine(); i++) {
            String line = scan.nextLine();
            String[] account = line.split(" ");
            try {

                Account newAccount = createObject(account);
                accounts.add(newAccount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return accounts;
    }

    /**
     * Name: returnAccounts()
     * 
     * @return ArrayList<Account>
     * @throws FileNotFoundException
     * 
     *                               Inside the function:
     *                               1. Creates a Scanner object and reads the data
     *                               from accounts.txt.
     *                               2. Creates an Account object for every line in
     *                               accounts.txt.
     *                               3. Returns an ArrayList of Account objects.
     */

    /**
     * Function name: wait
     * 
     * @param milliseconds
     * 
     *                     Inside the function:
     *                     1. Makes the code sleep for X milliseconds.
     */

    public static void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
