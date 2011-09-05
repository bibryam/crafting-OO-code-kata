package com.bilgin.accounting;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.assertTrue;

public class EndToEndTest {

    private Date date;
    private StringBuilder stringBuilder;
    private StatementPrinter printer;

    @Before
    public void setUp() {
        date = new Date();
        stringBuilder = new StringBuilder();
        printer = new ConsolePrinter(stringBuilder);
    }

    @Test
    public void printEmptyStatement() {
        Account account = anAccount();
        AccountStatement statement = account.generateStatement();

        printer.print(statement);
        assertTrue(stringBuilder.toString().equals(emptyStatement()));
    }

    private String emptyStatement() {
        return  "---------------Statement--------------------\n" +
                "---------------Transactions-----------------\n" +
                "---------------Total Amount-----------------\n" +
                "Amount: 0\n" +
                "---------------Total Balance----------------\n" +
                "Amount: 0\n";
    }

    @Test
    public void printStatementWithThreeTransactions() {
        Account account = anAccount();
        account.deposit(anAmountOf(10), date);
        account.deposit(anAmountOf(5), date);
        account.withdrawal(anAmountOf(7), date);
        AccountStatement statement = account.generateStatement();

        printer.print(statement);
        assertTrue(stringBuilder.toString().equals(transactionsResult()));
    }

    private String transactionsResult() {
        return  "---------------Statement--------------------\n" +
                "---------------Transactions-----------------\n" +
                "Deposit transaction:    " + date + ": Amount: 10\n" +
                "Deposit transaction:    " + date + ": Amount: 5\n" +
                "WithDrawal transaction: " + date + ": Amount: 7\n" +
                "---------------Total Amount-----------------\n" +
                "Amount: 8\n" +
                "---------------Total Balance----------------\n" +
                "Amount: 8\n";
    }

    private Amount anAmountOf(int value) {
        return new Amount(value);
    }


    private Account anAccount() {
        return new Account();
    }
}
