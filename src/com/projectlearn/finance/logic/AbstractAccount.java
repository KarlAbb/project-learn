package com.projectlearn.finance.logic;
import java.lang.*;

public class AbstractAccount implements Account {
    private int accountID;
    private int balance;

    //constructor
    public AbstractAccount(int accountID) {
        this.accountID = accountID;
        this.balance = 0;
    }


    @Override
    public int getID() {
        return accountID;
    }

    @Override
    public double getBalance() { return balance; }

    @Override public void withdraw(double amount){
        if (balance - amount >= 0){
            this.balance -= amount;
        }
    }

    @Override public void deposit(double amount){
            this.balance += amount;
        }

}
