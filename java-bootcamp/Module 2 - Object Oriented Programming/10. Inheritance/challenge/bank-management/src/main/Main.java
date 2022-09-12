package src.main;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    }

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
