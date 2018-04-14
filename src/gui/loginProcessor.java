package gui;

import com.projectlearn.business.finance.Account;
import com.projectlearn.business.finance.AccountList;

import java.util.ArrayList;

public class loginProcessor  {
    AccountList accounts;


    public loginProcessor(){
        accounts = new AccountList();
        accounts.addAccounts();
    }



    //the job of this method
    //pass email and password to the method
    // check if email and pass are in accountlist and are a match
    // returns true
    public boolean checkLogin(String email, String password){
        boolean status = false;
        if (accounts.checkInfo(email,password)){
            status = true;
        }
        return status;
    }

  }





