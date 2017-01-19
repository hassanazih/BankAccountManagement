package fr.sg.account.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class Operation {

    private final AccountOperationType type;
    private final LocalDate date;
    private final BigDecimal amount;

    public Operation(AccountOperationType operation, LocalDate date, BigDecimal amount) {
        this.type = operation;
        this.date = date;
        this.amount = amount;
    }

    public AccountOperationType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
