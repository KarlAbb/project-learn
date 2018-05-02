//regex n stuff will be on the controller class

package com.projectlearn.finance.logic;

import java.time.LocalDate;

public class Employee extends AbstractAccount {
    private String name;
    private String password;
    private int id;
    //private LocalDate dob; // must be this format (year,month,day);
    private String email;
    private EmpType empType;
    private AbstractAccount abstractAccount;

    public Employee(int id,String name,String passwd,String email,EmpType empType){
        this.id = id;
        this.name = name;
        this.password = passwd;
        //this.dob = dob;
        this.email = email;
        this.empType = empType;

        //create new acc when emp is created
        this.abstractAccount = new AbstractAccount(id);


    }




    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }




    //getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }



    public String getEmail() {
        return email;
    }

    public EmpType getEmpType() {
        return empType;
    }
}
