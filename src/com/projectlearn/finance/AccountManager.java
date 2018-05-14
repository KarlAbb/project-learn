package com.projectlearn.finance;

import java.util.HashMap;

public class AccountManager {
    //The HashMap that stores all accounts with the account number as the key and an Account as a value
    private static HashMap<Integer, Account> accounts = new HashMap();

    //default constructor
    public AccountManager() {

    }

    //returns the HashMap and creates a new one if it doesn't exist
    public static HashMap<Integer, Account> getList() {
        if (accounts == null) {
            accounts = new HashMap<>();
        }
            return accounts;
    }

    //adds a new account
    public static void setAccounts(int accountNum, Account account) {
        //checks to see if an account exists and warns if replacing an existing account
        boolean key = accounts.containsKey(accountNum);
        if(key == false) {
            accounts.put(accountNum, account);
        }
        else System.out.println("WARNING: REPLACING ACCOUNT");
        accounts.put(accountNum, account);
    }

    //gets a certain account
    public static Account getAccount(int accountNum) {
        return accounts.get(accountNum);
    }

    //checks the password of an account
    public static boolean checkInfo(int accountNum, String password) {
        if (AccountManager.getAccount(accountNum).getAccountPassword() == password) {
            return true;
        }
        else return false;
    }

    //gets whole account list
    public HashMap<Integer, Account> getAccounts(){
        return accounts;
    }

}
