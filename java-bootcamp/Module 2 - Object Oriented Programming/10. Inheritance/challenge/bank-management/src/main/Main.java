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
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t" + account + "\n\n");
                transactionHistory(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Account createObject(String[] values) {

        try {
            return (Account) Class.forName("src.main.model.account." + values[0])
                    .getConstructor(String.class, String.class, double.class)
                    .newInstance(values[1], values[2], Double.parseDouble(values[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static ArrayList<Account> returnAccounts() throws FileNotFoundException {
        ArrayList<Account> accounts = new ArrayList<>();

        FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] account = line.split(",");

            Account newAccount = createObject(account);
            accounts.add(newAccount);
        }

        return accounts;
    }

    public static void loadAccounts(ArrayList<Account> accounts) {
        for (Account account : accounts) {
            bank.addAccount(account);
        }
    }

    public static ArrayList<Transaction> returnTransactions() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
        Scanner scan = new Scanner(fis);

        ArrayList<Transaction> transactions = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineArr = line.split(",");
            Transaction transaction = new Transaction(Transaction.Type.valueOf(lineArr[1]), Long.parseLong(lineArr[0]),
                    lineArr[2],
                    Double.parseDouble(lineArr[3]));
            transactions.add(transaction);
        }
        return transactions;
    }

    public static void runTransactions(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            bank.executeTransaction(transaction);
        }
    }

    public static void transactionHistory(String id) {
        System.out.println("\t\t\t\t TRANSACTION HISTORY\n\t");
        Transaction[] transactions = bank.getTransactions(id);
        for (int i = 0; i < transactions.length; i++) {
            System.out.println("\t" + transactions[i] + "\n");
            wait(300);
        }
        System.out.println("\n\t\t\t\t\tAFTER TAX\n");

        System.out.println(bank.getAccount(id));

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
