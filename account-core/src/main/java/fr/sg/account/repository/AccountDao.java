package fr.sg.account.repository;

import fr.sg.account.domain.Account;

import java.math.BigDecimal;

public interface AccountDao {

    void deposit(Account account, BigDecimal amount);
   
}
