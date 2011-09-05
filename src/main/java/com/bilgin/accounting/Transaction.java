package com.bilgin.accounting;

public interface Transaction {
    void print(StatementPrinter printer);
    Amount applyTo(Amount amount);
}
