Feature: Account deposit
  Every customer should be able to make deposit on his bank account.

  Scenario: Make positive deposit on account
    Given an account identified by '1' and with a ledger balance equal to '100' euros
    And an account identified by '2' and with a ledger balance equal to '200' euros
    And an account identified by '3' and with a ledger balance equal to '300' euros
    When the customer make deposit of '10' euros on account identified by '1'
    Then the new available balance of the account identified by 1 should be 110

  Scenario: Make negative deposit on account
    Given an account identified by '1' and with a ledger balance equal to '100' euros
    And an account identified by '2' and with a ledger balance equal to '200' euros
    And an account identified by '3' and with a ledger balance equal to '300' euros
    When the customer make deposit of '-10' euros on account identified by '2'
    Then the available balance of the account identified by 2 should remain 200