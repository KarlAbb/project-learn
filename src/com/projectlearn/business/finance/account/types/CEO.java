package com.projectlearn.business.finance.account.types;

import com.projectlearn.business.finance.account.Account;
import com.projectlearn.business.finance.account.AccountType;

import java.util.UUID;

public class CEO extends Account {


    private String name;
    private UUID ID;
    private String password;
    private Integer AccountLogins;

    public CEO(String name, UUID ID, String Password, Integer AccountLogins) {
        super(name, ID, Password, AccountType.CEO, AccountLogins);
        this.name = name;
        this.ID = ID;
        this.password = Password;
        this.AccountLogins = AccountLogins;
    }


    @Override
    public AccountType getAccountType() {
       return AccountType.CEO;
    }
}
