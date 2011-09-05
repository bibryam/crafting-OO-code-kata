package com.bilgin.accounting;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WithDrawalTransactionTest {

    private Date date;
    private StatementPrinter printer;

    @Before
    public void setUp() throws Exception {
        date = new Date();
        printer = mock(StatementPrinter.class);
    }

    @Test
    public void testPrintTransaction() throws Exception {
        Amount amount = mock(Amount.class);
        Transaction transaction = new WithDrawalTransaction(amount, date);
        transaction.print(printer);
        verify(printer).printRaw("WithDrawal transaction: " + date + ": ");
        verify(amount).print(printer);
    }
}
