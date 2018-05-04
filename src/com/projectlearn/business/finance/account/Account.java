package com.projectlearn.business.finance.account;

import java.util.UUID;

public interface Account {

    // getters
    public String getName();
    public UUID getID();
    public String getPassword();
    public AccountType getAccountType();
    public int getAccountLogins();


    // functions
    public void incrementLogins();


}
