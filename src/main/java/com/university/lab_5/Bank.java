package com.university.lab_5;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<BankAccount> accounts;
    private int nextAccountNumber = 1;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        try {
            BankAccount newAccount = new BankAccount(nextAccountNumber, accountName, initialDeposit);
            accounts.add(newAccount);
            nextAccountNumber++;
            return newAccount;
        } catch (NegativeAmountException e) {
            System.err.println("Error creating account: " + e.getMessage());
            return null;
        }
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Cant find account");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        try {
            BankAccount fromAccount = findAccount(fromAccountNumber);
            BankAccount toAccount = findAccount(toAccountNumber);
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful. From: " + fromAccount.getAccountNumber() +
                    ", To: " + toAccount.getAccountNumber() +
                    ", Amount: " + amount);
        } catch (NegativeAmountException | InsufficientFundsException | AccountNotFoundException e) {
            System.err.println("Transfer failed: " + e.getMessage());
        }
    }
}