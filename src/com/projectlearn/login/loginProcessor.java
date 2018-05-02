
package com.projectlearn.login;

import com.projectlearn.finance.logic.*;

import java.util.HashMap;

public class loginProcessor  {
    EmployeeList emplist;

    public loginProcessor(){
        emplist = new EmployeeList();
        emplist.addAccounts(01,new Employee(
                01,"john","password","asd",EmpType.SYSADMIN
        ));

        //just testing

    }



    //the job of this method
    //pass email and password to the method
    // check if email and pass are in accountlist and are a match
    // returns true
    public boolean checkLogin(int id, String password){
        boolean status = false;
        if (emplist.checkLoginInfo(id,password)){
            status = true;
        }
        return status;
    }

  }



