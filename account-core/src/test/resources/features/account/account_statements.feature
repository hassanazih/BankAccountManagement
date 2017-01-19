Feature: Account history
  Every customer should be able to view all operations done on his account.

  Scenario: New account
    Given a new account identified by '1' with an initial balance of '0' euros
    When the customer access account history
    Then the account identified by '1' should have an empty statement

  Scenario: Existent account
    Given an existent account identified by '1' with an available balance equal to '123' euros
    And the owner of the account identified by '1' did a first deposit operation of '200' euros
    And the owner of the account identified by '1' did a withdrawal of '77' euros
    When the customer access account history
    Then he should see 2 operations done on his account identified by 1
    And the balance of account identified by 1 should be 246 euros