package com.projectlearn.business.finance.account;

import com.projectlearn.business.builders.AccountBuilder;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public abstract class Account {

    private String name;
    private UUID ID;
    private String password;
    private AccountType type;
    private int AccountLogins;

    private AccountBuilder accountBuilder;

    public Account(String name, UUID ID, String password, AccountType type, int accountLogins) {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.type = type;
        this.AccountLogins = accountLogins;
        this.accountBuilder = new AccountBuilder();
    }

    // getters
    public String getName() {
        return this.name;
    }
    public UUID getID() {
        return this.ID;
    }
    public String getPassword() {
        return this.password;
    }
    public abstract AccountType getAccountType();

    public int getAccountLogins() {
        return AccountLogins;
    }

    public AccountBuilder getAccountBuilder() {
        return accountBuilder;
    }

    // functions
    public void incrementLogins() {
        this.AccountLogins++;
    }


}
