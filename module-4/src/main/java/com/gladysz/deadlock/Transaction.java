package com.gladysz.deadlock;

public class Transaction {

    public static void main(String[] args) {
        final Bank bank = new Bank();

        final BankAccount firstAccount = new BankAccount("1111", 3000);
        final BankAccount secondAccount = new BankAccount("2222", 2000);

        final Thread bankUser1 = new Thread(() -> bank.transfer(firstAccount, secondAccount, 500));
        final Thread bankUser2 = new Thread(() -> bank.transfer(secondAccount, firstAccount, 300));

        bankUser1.start();
        bankUser2.start();
    }
}
