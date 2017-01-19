package fr.sg.account.service;

import fr.sg.account.domain.Account;
import fr.sg.account.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class DefaultAccountService implements AccountService {

    @Autowired
    private AccountDao dao;

    public DefaultAccountService(AccountDao dao) {
        this.dao = dao;
    }

    public void add(Account account) {
        dao.add(account);
    }

    public Account find(BigInteger accountNumber) {
        List<Account> matchedAccounts = dao.find(accountNumber);
        validateFoundAccounts(matchedAccounts);
        return matchedAccounts.get(0);
    }

    public void deposit( BigInteger accountNumber, BigDecimal amount) {
        validateAccountNumber(accountNumber);
        validatePositiveAmount(amount);
        dao.deposit(find(accountNumber), amount);
    }


}
