package com.bilgin.accounting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private List<Transaction> accountTransactions = new ArrayList<Transaction>();

    public AccountStatement generateStatement() {
        return new AccountStatement(accountTransactions);
    }

    public void deposit(Amount amount, Date date) {
       accountTransactions.add(new DepositTransaction(amount, date));
    }


    public void withdrawal(Amount amount, Date date) {
        accountTransactions.add(new WithDrawalTransaction(amount, date));
    }
}
