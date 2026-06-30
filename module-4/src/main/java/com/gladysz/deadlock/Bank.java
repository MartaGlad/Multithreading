package com.gladysz.deadlock;

public class Bank {
    private static final Object lock = new Object();


    public void transfer(BankAccount from, BankAccount to, double amount) {

        synchronized (lock) {
            from.withdraw(amount);
            to.deposit(amount);
        }
    }
}
