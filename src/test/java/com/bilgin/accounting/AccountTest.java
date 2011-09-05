package com.bilgin.accounting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private Date date;

    @Before
    public void setUp() {
        date = new Date();
    }

    @Test
    public void accountSetup() {
        assertNotNull(anAccount());
    }

    @Test
    public void generateEmptyStatement() {
        Account account = anAccount();
        AccountStatement accountStatement = account.generateStatement();
        AccountStatement emptyStatement = new AccountStatement();
        assertTrue(accountStatement.equals(emptyStatement));
    }

    @Test
    public void testDepositStatement() {
        Account account = anAccount();
        account.deposit(anAmountOf(5), date);
        AccountStatement accountStatement = account.generateStatement();

        AccountStatement depositStatement = aStatementWith(aDepositFor(anAmountOf(5)));
        assertTrue(accountStatement.equals(depositStatement));
    }

    @Test
    public void testWithDrawalStatement() {
        Account account = anAccount();
        account.withdrawal(anAmountOf(5), date);
        AccountStatement accountStatement = account.generateStatement();

        AccountStatement withDrawalStatement = aStatementWith(aWithdrawalFor(anAmountOf(5)));
        assertTrue(accountStatement.equals(withDrawalStatement));
    }

    @Test
    public void statementWithDifferentTranasactions() {
        Account account = anAccount();
        account.deposit(anAmountOf(10), date);
        account.withdrawal(anAmountOf(3), date);
        AccountStatement accountStatement = account.generateStatement();

        AccountStatement twoTransactionStatement = aStatementWith(aDepositFor(anAmountOf(10)), aWithdrawalFor(anAmountOf(3)));
        assertTrue(accountStatement.equals(twoTransactionStatement));
    }

    private WithDrawalTransaction aWithdrawalFor(Amount amount) {
        return new WithDrawalTransaction(amount, date);
    }

    private DepositTransaction aDepositFor(Amount amount) {
        return new DepositTransaction(amount, date);
    }

    private AccountStatement aStatementWith(Transaction... transaction) {
        List<Transaction> accountTransactions = new ArrayList<Transaction>();
        accountTransactions.addAll(Arrays.asList(transaction));
        return new AccountStatement(accountTransactions);
    }

    private Amount anAmountOf(int value) {
        return new Amount(value);
    }

    private Account anAccount() {
        return new Account();
    }
}
