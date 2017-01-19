package fr.sg.account.service;

import fr.sg.account.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class DefaultAccountService implements AccountService {

    @Autowired
    private AccountDao dao;

    public DefaultAccountService(AccountDao dao) {
        this.dao = dao;
    }

    
    public void deposit( BigInteger accountNumber, BigDecimal amount) {
    }


}
