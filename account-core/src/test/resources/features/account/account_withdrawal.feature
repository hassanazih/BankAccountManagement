Feature: Account withdrawal
  Every customer should be able to withdraw money from his bank account.

  Scenario: Do correct withdrawal on account
    Given an account identified by '1' and with an available balance equal to '100' euros
    And an account identified by '2' and with an available balance equal to '200' euros
    And an account identified by '3' and with an available balance equal to '300' euros
    When the customer make a correct withdrawal of '10' euros on account identified by '3'
    Then the new available balance of the account identified by 3 should decrease to 290

  Scenario: Make incorrect withdrawal on account
    Given an account identified by '1' and with an available balance equal to '100' euros
    And an account identified by '2' and with an available balance equal to '200' euros
    And an account identified by '3' and with an available balance equal to '300' euros
    When the customer make an incorrect withdrawal of '250' euros on account identified by '2'
    Then the available balance of the account identified by 2 should stay at 200