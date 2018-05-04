package com.projectlearn.business.finance.account;

import javafx.util.Callback;

public abstract class AbstractFinancies {

    private Account account;

    /**
     * Default constructor, which would handle all Financial transactions.
     * @param account An already existing account.
     *
     */

    // Should I have an enum for Financial Types? And then do AbstractFinancies<Enum>?.
    // So I could group them.


    public AbstractFinancies(Account account) {
        this.account = account;
    }

    public AbstractFinancies(Account account, int Salary) {
        this.account = account;
        this.setSalary(Salary);
    }

    public AbstractFinancies(Account account, int Salary, int InitialBalance) {
        this.account = account;
        this.setSalary(Salary);
        this.incrementBalance(InitialBalance);
    }

    public abstract int getSalary();
    public abstract int getBalance();


    public abstract boolean sendPayment(AbstractFinancies Account, int money);

    public abstract void setSalary(int salary);
    public abstract void incrementBalance(int increment);



}
