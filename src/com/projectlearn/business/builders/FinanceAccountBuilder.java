package com.projectlearn.business.builders;

import com.projectlearn.business.finance.account.AbstractFinancies;
import com.projectlearn.business.finance.account.Account;
import com.projectlearn.business.finance.account.types.FinancialAccount;

public class FinanceAccountBuilder {

    private Account account;

    private int balance;
    private int salary;
    private int paymentDate;

    public FinanceAccountBuilder setAccount(Account account) {
        this.account = account;
        return this;
    }

    public FinanceAccountBuilder setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public FinanceAccountBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public FinanceAccountBuilder setPaymentDate(int paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public AbstractFinancies build() {
        if(account == null) throw new RuntimeException("Account cannot be null.");
        return new FinancialAccount(this.account, this.salary, this.balance);
    }



}
