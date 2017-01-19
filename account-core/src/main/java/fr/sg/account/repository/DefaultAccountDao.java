package fr.sg.account.repository;


import fr.sg.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class DefaultAccountDao implements AccountDao {

   
    public void deposit(Account account, BigDecimal amount) {
       
    }

}
