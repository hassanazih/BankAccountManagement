package fr.sg.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountHistorySteps {

    @Given("^a new account identified by '(\\d+)' with an initial balance of '(\\d+)' euros$")
    public void a_new_account_identified_by_with_an_initial_balance_of_euros(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the customer access account history$")
    public void the_customer_access_account_history() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^he should see an empty statement$")
    public void he_should_see_an_empty_statement() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^an existent account identified by '(\\d+)' with an available balance equal to '(\\d+)' euros$")
    public void an_existent_account_identified_by_with_an_available_balance_equal_to_euros(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the owner of the account identified by '(\\d+)' did a first deposit operation of '(\\d+)' euros$")
    public void the_owner_of_the_account_identified_by_did_a_first_deposit_operation_of_euros(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the owner of the account identified by '(\\d+)' did a withdrawal of '(\\d+)' euros$")
    public void the_owner_of_the_account_identified_by_did_a_withdrawal_of_euros(int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^he should see (\\d+) operations$")
    public void he_should_see_operations(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
