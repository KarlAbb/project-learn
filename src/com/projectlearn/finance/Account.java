package com.projectlearn.finance;
import java.lang.*;

public class Account {
    private int accountID;
    private int balance;
    private String accountType;
    private int paycheckAmount;
    private int payInterval;
    private int accountNum;

    private String name;
    private String email;
    private String password;

    //constructor
    public Account(int accountNum, int balance, String name, String email, String password, int id, String accountType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountID = id;
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.balance = balance;
    }


    public int deposit(int amount) {
        balance += amount;
        return balance;
    }


    //withdraw
    public int withdraw(int amount) {
        balance -= amount;
        if(balance < 0) {
            return -1;
        }
        else return balance;
    }






    //getters and setters
    public int getAccountNum() {
        return accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getPaycheckAmount() {
        return paycheckAmount;
    }

    public int getPayInterval() {
        return payInterval;
    }

    public String getAccountLogins(){
        return this.name;
    }

    public String getAccountPassword(){
        return this.password;
    }

    public int getBalance() { return balance; }

    public void setBalance(int amount) {
        balance = amount;
    }

    public String getName() {
        return name;
    }

}
