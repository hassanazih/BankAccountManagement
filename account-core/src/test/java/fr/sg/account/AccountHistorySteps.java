package fr.sg.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.sg.account.domain.Account;
import fr.sg.account.repository.AccountDao;
import fr.sg.account.repository.DefaultAccountDao;
import fr.sg.account.service.DefaultAccountService;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountHistorySteps {

    private AccountDao dao = new DefaultAccountDao();

    private DefaultAccountService service = new DefaultAccountService(dao);


    @Given("^a new account identified by '(\\d+)' with an initial balance of '(\\d+)' euros$")
    public void new_account(BigInteger id, BigDecimal balance) throws Throwable {
       service.add(new Account(id,balance));
    }

    @When("^the customer access account history$")
    public void the_customer_access_account_history() throws Throwable {
    }

    @Then("^the account identified by '(\\d+)' should have an empty statement$")
    public void he_should_see_an_empty_statement(BigInteger accountNumber) throws Throwable {
        Assertions.assertThat(service.find(accountNumber).getOperations()).isEmpty();
    }

    @Given("^an existent account identified by '(\\d+)' with an available balance equal to '(\\d+)' euros$")
    public void an_existent_account_identified_by_with_an_available_balance_equal_to_euros(BigInteger id, BigDecimal balance) throws Throwable {
        service.add(new Account(id,balance));
    }

    @Given("^the owner of the account identified by '(\\d+)' did a first deposit operation of '(\\d+)' euros$")
    public void the_owner_of_the_account_identified_by_did_a_first_deposit_operation_of_euros(BigInteger id, BigDecimal amount) throws Throwable {
        service.deposit(id,amount);
    }

    @Given("^the owner of the account identified by '(\\d+)' did a withdrawal of '(\\d+)' euros$")
    public void the_owner_of_the_account_identified_by_did_a_withdrawal_of_euros(BigInteger id, BigDecimal amount) throws Throwable {
        service.withdraw(id,amount);
    }

    @Then("^he should see (\\d+) operations done on his account identified by (\\d+)$")
    public void he_should_see_operations(int operationsNumber,BigInteger accountNumber) throws Throwable {
       Assertions.assertThat(service.find(accountNumber).getOperations().size()).isEqualTo(operationsNumber);
    }

    @Then("^the balance of account identified by (\\d+) should be (\\d+) euros$")
    public void the_balance_of_account_identified_by_should_be_euros(BigInteger id, BigDecimal balance) throws Throwable {
       Assertions.assertThat(service.find(id).getBalance()).isEqualTo(balance);
    }

}
