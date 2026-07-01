package com.gladysz.deadlock;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    void deposit(double amount) {
        System.out.println("Deposit " + amount);
        balance += amount;
    }


    void withdraw(double amount) {
        System.out.println("Withdraw " + amount);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        balance -= amount;
    }
}
