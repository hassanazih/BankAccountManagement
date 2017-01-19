package fr.sg.account.repository;

import fr.sg.account.domain.Account;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface AccountDao {

    void deposit(Account account, BigDecimal amount);
    void add(Account account);
    List<Account> find(BigInteger accountNumber);
}
