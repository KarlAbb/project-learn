package com.projectlearn.finance;

public abstract class AccountManager {

    private int accountID;
    private int balance;
    private String accountType;
    private int paycheckAmount;
    private int payInterval;
    private int accountNum;

    private String name;
    private String email;
    private String password;

    public AccountManager (int accountNum, int balance, String name, String email, String password, int id, String accountType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountID = id;
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.balance = balance;
    }
}
