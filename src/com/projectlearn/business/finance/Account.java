package com.projectlearn.business.finance;

public class Account {
    private int accountNum;
    private int balance;
    private String accountType;
    private int paycheckAmount;
    private int payInterval;

    public Account(int accountNum, int balance, String accountType, int paycheckAmount, int payInterval) {
        this.accountNum = accountNum;
        this.balance = balance;
        this.accountType = accountType;
        this.paycheckAmount = paycheckAmount;
        this.payInterval = payInterval;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getBalance() {
        return balance;
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
}
