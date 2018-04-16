package com.projectlearn.business.finance;

import java.util.HashMap;

public class AccountList {
    private static HashMap<Integer, Account> accounts = new HashMap();

    public static HashMap<Integer, Account> getList() {
        if (accounts == null) {
            accounts = new HashMap<>();
        }
            return accounts;
    }

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

    public static Account getAccount(int accountNum) {
        return accounts.get(accountNum);
    }

    public static void deposit(int accountNum, int amount) {
        boolean key = accounts.containsKey(accountNum);
        if(key == true) {
            Account depositAccount = accounts.get(accountNum);
            int balance = depositAccount.getBalance(accountNum);
            System.out.println(balance);
            depositAccount.setBalance(balance + amount);

        }
    }

    public HashMap<Integer, Account> getAccounts(){
        return accounts;
    }

    public static void updateAccounts(HashMap<Integer, Account> newAccount) {
        accounts = newAccount;
    }

}
