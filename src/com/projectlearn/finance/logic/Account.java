package com.projectlearn.finance.logic;

public interface Account {

    public void withdraw(double amount);

    public void deposit(double amount);

    public double getBalance();

    public int getID();
}
