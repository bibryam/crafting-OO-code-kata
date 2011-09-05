package com.bilgin.accounting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsolePrinterTest {

    private ConsolePrinter consolePrinter;
    private StringBuilder stringBuilder;
    private AccountStatement statement;

    @Before
    public void setUp() throws Exception {
        stringBuilder = new StringBuilder();
        consolePrinter = new ConsolePrinter(stringBuilder);
        statement = mock(AccountStatement.class);
    }

    @Test
    public void testPrintStatement() throws Exception {
        consolePrinter.print(statement);

        assertTrue(stringBuilder.toString().contains("Statement"));
        verify(statement).print(consolePrinter);
    }

    @Test
    public void testPrintTransactions() throws Exception {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction transactionOne = mock(Transaction.class);
        transactions.add(transactionOne);
        Transaction transactionTwo = mock(Transaction.class);
        transactions.add(transactionTwo);
        consolePrinter.printTransactions(transactions);

        assertTrue(stringBuilder.toString().contains("Transactions"));
        verify(transactionOne).print(consolePrinter);
        verify(transactionTwo).print(consolePrinter);
    }

    @Test
    public void testPrintAmount() throws Exception {
        Amount amount = mock(Amount.class);
        consolePrinter.printTotalAmount(amount);

        assertTrue(stringBuilder.toString().contains("Amount"));
        verify(amount).print(consolePrinter);

    }

    @Test
    public void testPrintBalance() throws Exception {
        Amount amount = mock(Amount.class);
        consolePrinter.printTotalBalance(amount);

        assertTrue(stringBuilder.toString().contains("Balance"));
        verify(amount).print(consolePrinter);
    }
}
