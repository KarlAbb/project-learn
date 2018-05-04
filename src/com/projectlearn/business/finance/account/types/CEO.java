package com.projectlearn.business.finance.account.types;

import com.projectlearn.business.finance.account.Account;
import com.projectlearn.business.finance.account.AccountType;

import java.util.UUID;

public class CEO implements Account {


    private String name;
    private UUID ID;
    private String password;
    private Integer AccountLogins;

    public CEO(String name, UUID ID, String Password, Integer AccountLogins) {
        this.name = name;
        this.ID = ID;
        this.password = Password;
        this.AccountLogins = AccountLogins;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getID() {
        return ID;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public AccountType getAccountType() {
       return AccountType.CEO;
    }

    @Override
    public int getAccountLogins() {
        return AccountLogins;
    }

    @Override
    public void incrementLogins() {
        this.AccountLogins++;
    }

}
