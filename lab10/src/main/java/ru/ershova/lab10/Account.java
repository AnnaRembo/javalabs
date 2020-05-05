package ru.ershova.lab10;

/**
 * @author Anna
 */
public class Account {
    private String id;
    private volatile Integer balance;

    public Account(String id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getBalance() { return this.balance; }
    public String getId() { return this.id; }

    public void decrement(int summ) {
        this.balance -= summ;
    }

    public void increment(int summ) {
        this.balance += summ;
    }
}
