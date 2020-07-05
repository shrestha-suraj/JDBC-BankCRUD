package com.bank.domain;

public class Account {
    private int id;
    private Bank bank;
    private Patron patron;

    public Account(int id, Bank bank, Patron patron) {
        this.id = id;
        this.bank = bank;
        this.patron = patron;
    }

    public int getId() {
        return id;
    }

    public Bank getBank() {
        return bank;
    }

    public Patron getPatron() {
        return patron;
    }
}
