package fr.sg.account.service;


import fr.sg.account.domain.Account;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface AccountService {

    void deposit(BigInteger accountNumber, BigDecimal amount);
    void add(Account account);
    Account find(BigInteger accountNumber);
    void withdraw(BigInteger accountNumber, BigDecimal amount);
}
