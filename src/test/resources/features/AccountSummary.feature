@account
Feature: Account summary page
  Scenario:	Verify the title
    Given user is on the login page
    When user logs in with valid credentials
    Then the title should be Zero – Account summary


  Scenario: Account types
    Given user is on the login page
    When user logs in with valid credentials
    Then the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit account table
    Given user is on the login page
    When user logs in with valid credentials
    Then "Credit Accounts" table must have columns

      |Account    |
      |Credit Card|
      |Balance    |