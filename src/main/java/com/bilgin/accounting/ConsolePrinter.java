package com.bilgin.accounting;

import java.util.List;

public class ConsolePrinter implements StatementPrinter {
    private final StringBuilder stringBuilder;

    public ConsolePrinter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void print(AccountStatement statement) {
        printRaw("---------------Statement--------------------");
        newLine();
        statement.print(this);
    }

    public void printTransactions(List<Transaction> transactions) {
        printRaw("---------------Transactions-----------------");
        newLine();
        for (Transaction transaction : transactions) {
            printTransaction(transaction);
        }
    }

    private void printTransaction(Transaction transaction) {
        transaction.print(this);
        newLine();
    }

    public void printTotalAmount(Amount amount) {
        printRaw("---------------Total Amount-----------------");
        newLine();
        amount.print(this);
        newLine();
    }

    public void printTotalBalance(Amount amount) {
        printRaw("---------------Total Balance----------------");
        newLine();
        amount.print(this);
        newLine();
    }

    public void printRaw(String text) {
        stringBuilder.append(text);

    }

    private void newLine() {
        stringBuilder.append("\n");
    }
}
