package com.projectlearn.business.builders;

import com.projectlearn.business.finance.account.Account;
import com.projectlearn.business.finance.account.AccountType;
import com.projectlearn.business.finance.account.types.CEO;

import java.util.UUID;

public class AccountBuilder {

    private String name;
    private UUID ID;
    private String Password;
    private AccountType type;
    private Integer AccountLogins;

    public AccountBuilder withID(UUID ID) {
        this.ID = ID;
        return this;
    }

    public AccountBuilder withPassword(String password) {
        Password = password;
        return this;
    }

    public AccountBuilder withAccountType(AccountType accountType) {
        type = accountType;
        return this;
    }

    public AccountBuilder withAccountLogins(Integer accountLogins) {
        AccountLogins = accountLogins;
        return this;
    }

    public AccountBuilder withName(String name) {
        this.name = name;
        return this;
    }


    public Account finishAccount() {
        if(this.ID == null) this.ID = UUID.randomUUID();
        if(this.Password == null) throw new RuntimeException("Every Account should have a Password.");
        if(this.name == null) throw new RuntimeException("Every Account should have a name.");
        switch(this.type) {
            case CEO:
                return new CEO(this.name, this.ID, this.Password, this.AccountLogins);
        }
        return null;
    }
}
