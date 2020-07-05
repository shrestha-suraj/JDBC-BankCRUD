package com.bank.domain;

public class Transaction {
    private int id;
    private Account account;
    private double amount;
    private AccountType accountType;

    public Transaction(int id, Account account, double amount, AccountType accountType) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
