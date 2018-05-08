package com.projectlearn.finance.logic;

import java.util.HashMap;
import java.util.Map;

public class EmployeeList {

    private static HashMap<Integer, Employee> accountList = new HashMap();

    public static HashMap<Integer, Employee> getList() {
        if (accountList == null) {
            accountList = new HashMap<>();
        }
            return accountList;
    }

    public EmployeeList() {

    }


    //adds a new account
    public static void addAccounts(int accID, Employee employee) {
        boolean key = accountList.containsKey(accID);
        if(!key) {
            accountList.put(accID, employee);
        }

    }

    //get the balance of an account
    public static double getAccountBalance(int accID) {
        double balance = 0;
        for (Map.Entry<Integer,Employee> a : accountList.entrySet()) {
            int key = a.getKey();
            balance = a.getValue().getBalance();
       }
        return balance;
           }

    public static void withdrawFromAcc(int accID, double amount) {

        for (Map.Entry<Integer,Employee> a : accountList.entrySet()) {
            int key = a.getKey();
             a.getValue().withdraw(amount);
        }

    }

    public static void depositToAcc(int accID, double amount) {

        for (Map.Entry<Integer,Employee> a : accountList.entrySet()) {
            int key = a.getKey();
            a.getValue().deposit(amount);
        }

    }

    public static boolean checkLoginInfo(int accID, String passwd) {

        boolean log = false;
        for (Map.Entry<Integer,Employee> a : accountList.entrySet()) {
            int key = a.getKey();
            if(a.getValue().loginInfor(accID,passwd)){
                log = true;
            }
        }
        return log;

    }





}
