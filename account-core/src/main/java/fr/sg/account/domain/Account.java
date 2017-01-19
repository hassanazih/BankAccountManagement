package fr.sg.account.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Account {

    private final BigInteger id;

    private BigDecimal balance;

    public Account(final BigInteger id, final BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public final BigInteger getId() {
        return id;
    }

    public final BigDecimal getBalance() {
        return balance;
    }

    public void addAmount(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void subtractAmount(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
