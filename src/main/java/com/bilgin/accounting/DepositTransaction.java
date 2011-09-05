package com.bilgin.accounting;

import java.util.Date;

public class DepositTransaction implements Transaction {

    private Date date;
    private final Amount amount;

    public DepositTransaction(Amount amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepositTransaction that = (DepositTransaction) o;

        if (!amount.equals(that.amount)) return false;
        if (!date.equals(that.date)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    public void print(StatementPrinter printer) {
        printer.printRaw("Deposit transaction:    " + date + ": ");
        amount.print(printer);
    }

    public Amount applyTo(Amount amount) {
        return amount.sum(this.amount);
    }
}
