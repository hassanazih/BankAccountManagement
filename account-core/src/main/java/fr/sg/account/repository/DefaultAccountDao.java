package fr.sg.account.repository;


import fr.sg.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultAccountDao implements AccountDao {

    private final List<Account> accounts = new ArrayList<Account>();

    public void deposit(Account account, BigDecimal amount) {
        accounts.stream()
                .filter(a -> a.getId().equals(account.getId()))
                .findFirst()
                .get()
                .addAmount(amount);
    }

}
