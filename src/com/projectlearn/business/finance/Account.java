package com.projectlearn.business.finance;

public class Account {
    private int accountID;
    private int balance;
    private String accountType;
    private int paycheckAmount;
    private int payInterval;

    private String name;
    private String email;
    private String password;

    //constructor
    public Account(String name,String email, String password, int id, String accountType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountID = id;
        this.accountType = accountType;

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


    //this method checks whether the email and password are true
    public boolean CheckLogin(String email, String password){

        boolean status = false;
        if(this.email.equalsIgnoreCase(email) && this.password.equals(password)){
            status = true;
        }
        return status;
    }

}
