package com.university.lab_5;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = bank.createAccount("John Doe", 1000.0);
        BankAccount account2 = bank.createAccount("Jane Doe", 500.0);

        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 100.0);

        System.out.println("Account 1 Balance: " + account1.getBalance());
        System.out.println("Account 2 Balance: " + account2.getBalance());
    }
}