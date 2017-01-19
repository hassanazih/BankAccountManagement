package fr.sg.account.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface AccountService {

    void deposit(BigInteger accountNumber, BigDecimal amount);
   
}
