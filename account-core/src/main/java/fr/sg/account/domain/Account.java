package fr.sg.account.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private final BigInteger id;
    private BigDecimal balance;
    private List<Operation> operations;

    public Account(final BigInteger id, final BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        operations = new ArrayList<>();
    }

    public final BigInteger getId() {
        return id;
    }

    public final BigDecimal getBalance() {
        return balance;
    }

    public void addAmount(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        this.operations.add(new Operation(AccountOperationType.DEPOSIT, LocalDate.now(),amount));
    }

    public void subtractAmount(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        this.operations.add(new Operation(AccountOperationType.WITHDRAWAL, LocalDate.now(),amount));
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
