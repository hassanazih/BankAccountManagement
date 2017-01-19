package fr.sg.account.service;

import fr.sg.account.domain.Account;
import fr.sg.account.exception.AccountException;
import fr.sg.account.repository.AccountDao;
import fr.sg.account.repository.DefaultAccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class DefaultAccountService implements AccountService {

    @Autowired
    private AccountDao dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAccountService.class);

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

    @Override
    public void withdraw(BigInteger accountNumber, BigDecimal amount) {
        validateAccountNumber(accountNumber);
        validatePositiveAmount(amount);

        Account account = find(accountNumber);
        validateRemainingBalance(amount,account);
        dao.withdraw(find(accountNumber), amount);
    }

    private void validateRemainingBalance(BigDecimal amount, Account account) {
        if(amount.compareTo(account.getBalance()) > 0)
        {
            throw new AccountException(AccountException.AccountError.AVAILABLE_BALANCE_IS_INSUFFICIENT);
        }
    }


    private void validateAccountNumber( BigInteger accountNumber) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Parameter accountNumber is null");
        }
    }

    private void validatePositiveAmount(BigDecimal amount)
    {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.error("Weird situation, a customer tried to make a deposit with a negative value");
            throw new IllegalArgumentException("The amount should be positive");
        }
    }

    private void validateFoundAccounts(List<Account> accounts)
    {
        if (accounts == null || accounts.isEmpty()) {
            LOGGER.debug("An attempt to do some operations on inexistent account");
            throw new AccountException(AccountException.AccountError.NOT_FOUND);
        }
        if (accounts.size() > 1) {
            LOGGER.error("Weird situation, there is more than on account identified by {}",accounts.get(0).getId());
            throw new AccountException(AccountException.AccountError.MANY_ACCOUNTS_WITH_SAME_IDENTIFIER);
        }
    }


}
