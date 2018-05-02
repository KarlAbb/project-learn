package com.projectlearn.finance.logic;

import java.time.LocalDate;
import java.util.HashMap;

public class TmpTest {
    public static void main(String[] args) {


        Employee emp1 = new Employee(01,"john","123123123","12",
                EmpType.SYSADMIN);

        EmployeeList emplist = new EmployeeList();
        emplist.addAccounts(01,emp1);
        emp1.deposit(200);

        System.out.println(emplist.getAccountBalance(01));




    }



}
