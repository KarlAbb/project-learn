package com.projectlearn.finance;

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


    //adds a new account
    public static void setAccounts(int accountNum, Account account) {
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

    public static boolean checkInfo(int accountNum, String password) {
        if (AccountList.getAccount(accountNum).getAccountPassword() == password) {
            return true;
        }
        else return false;
    }

    public static void updateAccountList(int accountNum, Account newAccount) {
        accounts.put(accountNum, newAccount);

    }


    //gets whole account list
    public HashMap<Integer, Account> getAccounts(){
        return accounts;
    }

    public static void updateAccounts(HashMap<Integer, Account> newAccount) {
        accounts = newAccount;
    }


}
