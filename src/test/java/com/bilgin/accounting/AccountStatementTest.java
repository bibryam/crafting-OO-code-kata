package com.bilgin.accounting;

import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountStatementTest {
    @Test
    public void testStatementPrinting() throws Exception {
        AccountStatement accountStatement = new AccountStatement();
        StatementPrinter printer = mock(StatementPrinter.class);
        accountStatement.print(printer);
        verify(printer).printTransactions(any(List.class));
        verify(printer).printTotalAmount(any(Amount.class));
        verify(printer).printTotalBalance(any(Amount.class));
    }
}
