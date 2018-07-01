package com.projectlearn.finance.logic;

import java.lang.*;
import java.util.Set;

public class Account {
    public static int accountNumber = 1000;
    private int accountID;
    private int balance;
    private String accountType;
    private int paycheckAmount;
    private int payInterval;
    private int accountNum;

    private String name;
    private String email;
    private String password;

    private Set<Permissions> permissions;

    //constructor
    public Account(int balance, String name, String email, String password, int id, String accountType, Set<Permissions> perms) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountID = id;
        this.accountType = accountType;
        this.accountNum = accountNumber;
        this.balance = balance;
        this.permissions = perms;
        accountNumber++;
    }

    //deposit
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }


    //withdraw
    public int withdraw(int amount) {
        if(balance < 0) {
            return balance;
        }
        else if (balance >= amount){
            balance -= amount;
            return balance;
        }

        else return balance;
    }

    //sets the permission level
    public Set<Permissions> getPerms() {
        return permissions;
    }





    //getters and setters
    public int getAccountNum() {
        return accountNum;
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
        return password;
    }

    public int getBalance() { return balance; }

    public void setBalance(int amount) {
        balance = amount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountID () {
        return accountID;
    }
}
