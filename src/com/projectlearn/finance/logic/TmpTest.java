package com.projectlearn.finance.logic;

import java.util.HashMap;

public class TmpTest {
    public static void main(String[] args) {
        AbstractAccount john = new AbstractAccount(01);
        john.deposit(200);
        AccountList accountList = new AccountList();
        accountList.addAccounts(01,john);
        System.out.println(accountList.getAccountBalance(01));

    }
}
