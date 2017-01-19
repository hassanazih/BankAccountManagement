package fr.sg.account.service;

import fr.sg.account.domain.Account;
import fr.sg.account.exception.AccountException;
import fr.sg.account.repository.AccountDao;
import fr.sg.account.repository.DefaultAccountDao;
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

    private void validateAccountNumber( BigInteger accountNumber) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("There is no account identified by " + accountNumber);
        }
    }

    private void validatePositiveAmount(BigDecimal amount)
    {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The amount should be positive");
        }
    }

    private void validateFoundAccounts(List<Account> accounts)
    {
        if (accounts == null || accounts.isEmpty()) {
            throw new AccountException(AccountException.AccountError.NOT_FOUND);
        }
        if (accounts.size() > 1) {
            throw new AccountException(AccountException.AccountError.MANY_ACCOUNTS_WITH_SAME_IDENTIFIER);
        }
    }


}
