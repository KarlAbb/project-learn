package com.projectlearn.business.finance.account.types;


import com.projectlearn.business.finance.account.AbstractFinancies;
import com.projectlearn.business.finance.account.Account;
import javafx.util.Callback;

public class FinancialAccount extends AbstractFinancies {

    private int salary;
    private int balance;

    /**
     * Default constructor, which would handle all Financial transactions.
     *
     * @param account An already existing account.
     */

    // Possibly make like a Map<Account, FinancialAccount> ?

    public FinancialAccount(Account account) {
        super(account);
    }

    public FinancialAccount(Account account, int salary) {
        super(account, salary);
    }

    public FinancialAccount(Account account, int salary, int InitialBalance){
        super(account, salary, InitialBalance);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean sendPayment(AbstractFinancies Account, int money) {
        // business logic.
        // not yet implemented.
        return false;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void incrementBalance(int increment) {
        this.balance = balance + increment;
    }


}
