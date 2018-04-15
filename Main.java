package com.projectlearn.business;
import java.util.*;

class Employe{
    private String name;
    private String gender;
    private Date dob;

    public Employe( ){
        name = null;
        gender = null;
        dob = null;
    }
    public Employe(String nameValue, String newGender, Date newDob){
        name = nameValue;
        gender = newGender;
        dob = newDob;
    }
    public String getName(){
        return name;
    }
    public void setName(String nameValue){
        name = nameValue;
    }
    public Date getDateOfBirth(){
        return dob;
    }
}

