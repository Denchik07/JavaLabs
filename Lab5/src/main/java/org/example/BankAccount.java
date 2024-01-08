package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Amount for deposit cannot be negative.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Amount for withdrawal cannot be negative.");
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }

    public int getAccountNumber() {

        return 0;
    }
}



