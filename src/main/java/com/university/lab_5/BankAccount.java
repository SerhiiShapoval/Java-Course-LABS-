package com.university.lab_5;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    public BankAccount(Integer accountNumber, String accountName, Double balance) throws NegativeAmountException {
        if (balance < 0) throw new NegativeAmountException(("Balance cant be negative"));
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit (Double amount) throws NegativeAmountException {
        if (amount < 0) throw new NegativeAmountException("Deposit amount cant be negative");
        this.balance += amount;
    }

    public void withdraw (Double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) throw new NegativeAmountException("Deposit amount cant be negative");
        if (this.balance - amount < 0) throw new InsufficientFundsException("Cant withdraw amount bigger than account balance!");
        this.balance -= amount;
    }

    public Map<String, Object> getAccountSummary() {
        Map<String, Object> summary = new HashMap<>();
        summary.put("accountNumber", accountNumber);
        summary.put("accountName", accountName);
        summary.put("balance", balance);
        return summary;
    }

    public Double getBalance () {
        return this.balance;
    }

    public Integer getAccountNumber () {
        return this.accountNumber;
    }

    private Integer accountNumber;
    private String accountName;
    private Double balance;
}
