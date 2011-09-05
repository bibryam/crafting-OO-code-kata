package com.bilgin.accounting;

import java.util.Date;

public class StatementPeriod {
    private final Date fromDate;
    private final Date toDate;

    public StatementPeriod(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
