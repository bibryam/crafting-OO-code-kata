package com.bilgin.accounting;

import java.util.List;

public interface StatementPrinter {
    void print(AccountStatement statement);
    void printTransactions(List<Transaction> transactions);
    void printTotalAmount(Amount amount);
    void printTotalBalance(Amount amount);
    void printRaw(String text);
}
