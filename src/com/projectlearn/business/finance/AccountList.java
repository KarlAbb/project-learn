package com.projectlearn.business.finance;

import java.util.ArrayList;

public class AccountList {
    private ArrayList<Account> accountlist ;

    public AccountList(){
        accountlist = new ArrayList<Account>();
    }

    public void addAccounts(){
        this.accountlist.add(new Account
                ("john","john@gmail.com","pass",1,"basic"));
        this.accountlist.add(new Account
                ("fibi","fibi@email.fb","pass",1,"basic"));
        this.accountlist.add(new Account
                ("lebowski","lebowski@gmail.com","vietnam",1,"basic"));

    }

    public ArrayList<Account> getList(){
        return this.accountlist;
    }

    public boolean checkInfo(String email, String password){
        boolean status = false;
        for(Account a : accountlist){
             if (a.CheckLogin(email,password)) {
                 status = true;
             }
         }
        return status;
    }
}
