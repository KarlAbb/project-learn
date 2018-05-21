package com.projectlearn.finance;

import java.util.HashMap;
import java.util.Set;

public class AccountManager {
    public Set<Permissions> admin = Set.of(Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_PAY, Permissions.CAN_FINE, Permissions.CAN_VIEW_ACCOUNTS);
    public Set<Permissions> intern = Set.of(Permissions.CAN_WITHDRAW);
    public Set<Permissions> employee = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW);
    public Set<Permissions> hr = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_HIRE, Permissions.CAN_FIRE, Permissions.CAN_PAY, Permissions.CAN_VIEW_ACCOUNTS);
    public Set<Permissions> it = Set.of(Permissions.CAN_DEPOSIT, Permissions.CAN_WITHDRAW, Permissions.CAN_VIEW_ACCOUNTS);
    public Set<Permissions> noPerms = Set.of();

    //The HashMap that stores all accounts with the account number as the key and an Account as a value
    public HashMap<Integer, Account> accounts = new HashMap();
    public HashMap<String, Set<Permissions>> permissionSet = new HashMap<>();

    //default constructor
    public AccountManager() {

    }

    //returns the HashMap and creates a new one if it doesn't exist
    public HashMap<Integer, Account> getList() {
        if (accounts == null) {
            accounts = new HashMap<>();
        }
            return accounts;
    }

    //adds a new account
    public void setAccounts(int accountNum, Account account) {
        //checks to see if an account exists and warns if replacing an existing account
        boolean key = accounts.containsKey(accountNum);
        if (key == false) {
            accounts.put(accountNum, account);
        }
    }

    //gets a certain account
    public Account getAccount(int accountNum) {
        return accounts.get(accountNum);
    }

    //checks the password of an account
    public boolean checkInfo(int accountNum, String password) {
        if (getAccount(accountNum).getAccountPassword() == password) {
            return true;
        }
        else return false;
    }

    //gets whole account list
    public HashMap<Integer, Account> getAccounts(){
        return accounts;
    }

}
