package com.projectlearn.business.finance;
import java.lang.*;

public class Account {
    AccountList accounts = new AccountList();

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
//        this.accountID = id;
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.balance = balance;
    }


    public int deposit(int amount) {
        balance += amount;
        return balance;
    }


    //withdraw
    public static void withdraw(int accountNum, int amount) {
        Account temp = AccountList.getAccount(accountNum);
        int balance = temp.getBalance();
        balance -= amount;
        temp.addAccount(accountNum, temp);
    }

    //withdraw
    public void withdraw(double amount){
        this.balance -= amount;
    }

    //add account to AccountList
    public void addAccount(int accountNum, Account account) {
        accounts.setAccounts(accountNum, account);
    }

    public static String getAccountName(int accountNum) {
        Account temp = AccountList.getAccount(accountNum);
        return temp.getName();
    }

    public static int getAccountBalance(int accountNum) {
        Account temp = AccountList.getAccount(accountNum);
        return temp.getBalance();
    }

    public String getName() {
        return name;
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

}
