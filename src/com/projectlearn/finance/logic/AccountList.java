package com.projectlearn.finance.logic;

import java.util.HashMap;
import java.util.Map;

public class AccountList {

    private static HashMap<Integer, AbstractAccount> accountList = new HashMap();

    public static HashMap<Integer, AbstractAccount> getList() {
        if (accountList == null) {
            accountList = new HashMap<>();
        }
            return accountList;
    }

    public AccountList() {

    }


    //adds a new account
    public static void addAccounts(int accID, AbstractAccount account) {
        boolean key = accountList.containsKey(accID);
        if(!key) {
            accountList.put(accID, account);
        }

    }

    //get the balance of an account
    public static double getAccountBalance(int accID) {
        double balance = 0;
        for (Map.Entry<Integer,AbstractAccount> a : accountList.entrySet()) {
            int key = a.getKey();
            balance = a.getValue().getBalance();
       }
        return balance;
           }





}
