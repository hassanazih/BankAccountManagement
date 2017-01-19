package fr.sg.account.repository;


import fr.sg.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void add(Account account)
    {
        accounts.add(account);
    }

    public List<Account> find(BigInteger accountNumber)
    {
        return accounts.stream()
                        .filter(account -> accountNumber.equals(account.getId()))
                        .collect(Collectors.toList());
    }

}
