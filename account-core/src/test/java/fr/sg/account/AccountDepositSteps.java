package fr.sg.account;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.sg.account.domain.Account;
import fr.sg.account.repository.AccountDao;
import fr.sg.account.repository.DefaultAccountDao;
import fr.sg.account.service.DefaultAccountService;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountDepositSteps {

    private AccountDao dao = new DefaultAccountDao();

    private DefaultAccountService service = new DefaultAccountService(dao);

    @Given("^an account identified by '(\\d+)' and with a ledger balance equal to '(\\d+)' euros$")
    public void new_account(final BigInteger id, final BigDecimal balance) {
        Account account = new Account(id,balance);
        service.add(account);
    }

    @When("^the customer make deposit of '(\\d+)' euros on account identified by '(\\d+)'$")
    public void we_add_some_positive_amount_to_account_balance(BigDecimal amount,BigInteger accountNumber) {
            service.deposit(accountNumber, amount);
    }

    @When("^the customer make deposit of '-(\\d+)' euros on account identified by '(\\d+)'$")
    public void we_add_some_negative_amount_to_account_balance(BigDecimal amount,BigInteger accountNumber) {
        try {
            service.deposit(accountNumber, amount.negate());
        }
         catch (IllegalArgumentException exp)
        {
            Assertions.assertThat(exp.getMessage()).isEqualTo("The amount should be positive");
        }
    }

    @Then("the new available balance of the account identified by (\\d+) should be (\\d+)$")
    public void should_increase_available_balance(BigInteger accountNumber, BigDecimal availableBalance) {
        Assertions.assertThat(service.find(accountNumber).getBalance()).isEqualTo(availableBalance);
    }

    @Then("the available balance of the account identified by (\\d+) should remain (\\d+)$")
    public void should_not_change_available_balance_(BigInteger accountNumber, BigDecimal availableBalance) {
            Assertions.assertThat(service.find(accountNumber).getBalance()).isEqualTo(availableBalance);
    }


}
