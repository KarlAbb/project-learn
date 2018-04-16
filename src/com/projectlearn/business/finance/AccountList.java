package com.projectlearn.business.finance;

import java.util.HashMap;

public class AccountList {
    public HashMap<Integer, Account> accounts = new HashMap();

    public AccountList() {

    }

    //gets a certain account
    public Account getAccounts(int accountNum) {
        return accounts.get(accountNum);
    }

    //adds a new account
    public void setAccounts(int accountNum, Account account) {
        boolean key = accounts.containsKey(accountNum);
        if(key == false) {
            accounts.put(accountNum, account);
        }
        else System.out.println("error: account already exists");
        accounts.put(accountNum, account);
    }

    public void deposit(int accountNum, int amount) {
        boolean key = accounts.containsKey(accountNum);
        if(key == true) {
            Account depositAccount = accounts.get(accountNum);
            int balance = depositAccount.getBalance();
            depositAccount.setBalance(amount);

        }
    }

    public HashMap<Integer, Account> getAccounts(){
        return accounts;
    }

    public void updateAccounts(HashMap<Integer, Account> accounts) {
        this.accounts = accounts;
    }

}
