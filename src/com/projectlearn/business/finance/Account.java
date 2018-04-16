package com.projectlearn.business.finance;

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
    public Account(int accountNum, int balance /*String name, String email, String password, int id, String accountType*/) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.accountID = id;
        this.accountType = accountType;
        this.accountNum = accountNum;
        this.balance = balance;
    }
    //deposit
    public void deposit(int accountNum, int amount){

        this.balance += amount;
    }

    //withdraw
    public void withdraw(double amount){
        this.balance -= amount;
    }

    //add account to AccountList
    public void addAccount(int accountNum, Account account) {
        accounts.setAccounts(accountNum, account);
    }



    //getters
    public int getAccountNum() {
        return accountID;
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

    public String getAccountLogins(){
        return this.name;
    }

    public String getAccountPassword(){
        return this.password;
    }

    public void setBalance(int amount) {
        balance = amount;
    }

}
