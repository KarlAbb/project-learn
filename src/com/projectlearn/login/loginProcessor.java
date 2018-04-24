package com.projectlearn.login;

import com.projectlearn.business.finance.AccountList;

import java.util.HashMap;

public class loginProcessor  {
HashMap accounts;

    public loginProcessor(){
        HashMap accounts = AccountList.getList();
    }



    //the job of this method
    //pass email and password to the method
    // check if email and pass are in accountlist and are a match
    // returns true
    public boolean checkLogin(int accountNum, String password){
        boolean status = false;
        if (AccountList.checkInfo(accountNum, password)){
            status = true;
        }
        return status;
    }

  }





