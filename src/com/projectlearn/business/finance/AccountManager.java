package com.projectlearn.business.finance;

import java.util.HashMap;

public class AccountManager {
    HashMap<Integer, Account> accounts = new HashMap();

    public AccountManager() {

    }

    public void setAccounts(int accountNum, Account account) {
        accounts.put(accountNum, account);
    }
}
