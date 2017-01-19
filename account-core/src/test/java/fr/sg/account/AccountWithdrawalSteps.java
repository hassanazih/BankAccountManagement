package fr.sg.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.sg.account.domain.Account;
import fr.sg.account.exception.AccountException;
import fr.sg.account.repository.AccountDao;
import fr.sg.account.repository.DefaultAccountDao;
import fr.sg.account.service.DefaultAccountService;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountWithdrawalSteps {

    private AccountDao dao = new DefaultAccountDao();

    private DefaultAccountService service = new DefaultAccountService(dao);

    @Given("^an account identified by '(\\d+)' and with an available balance equal to '(\\d+)' euros$")
    public void new_account(final BigInteger id, final BigDecimal balance) {
        Account account = new Account(id,balance);
        service.add(account);
    }

    @When("^the customer make a correct withdrawal of '(\\d+)' euros on account identified by '(\\d+)'$")
    public void we_do_correct_withdrawal_on_account_balance(BigDecimal amount,BigInteger accountNumber) {
        service.withdraw(accountNumber, amount);
    }

    @When("^the customer make an incorrect withdrawal of '(\\d+)' euros on account identified by '(\\d+)'$")
    public void we_do_incorrect_withdrawal_on_account_balance(BigDecimal amount,BigInteger accountNumber) {
        try {
            service.withdraw(accountNumber, amount);
        }
        catch(AccountException exp)
        {
            Assertions.assertThat(exp.getError()).isEqualTo(AccountException.AccountError.AVAILABLE_BALANCE_IS_INSUFFICIENT);
        }
    }

    @Then("the new available balance of the account identified by (\\d+) should decrease to (\\d+)$")
    public void should_decrease_available_balance(BigInteger accountNumber, BigDecimal availableBalance) {
        Assertions.assertThat(service.find(accountNumber).getBalance()).isEqualTo(availableBalance);
    }

    @Then("the available balance of the account identified by (\\d+) should stay at (\\d+)$")
    public void should_not_change_available_balance_(BigInteger accountNumber, BigDecimal availableBalance) {
        Assertions.assertThat(service.find(accountNumber).getBalance()).isEqualTo(availableBalance);
    }
}
