@accountactivity
Feature: Account activity page

  Background: open login page
    Given user is on the login page
    When user logs in with valid credentials

  Scenario:	Verify the title
    Then the user clicks to Account	activity
    And the title should be Zero – Account	activity

  Scenario: DropDown default should be Saving
    Then the user clicks to Account	activity
    And the Account drop down default option should be Savings

  Scenario: DropDown  should have options
    Then the user clicks to Account	activity
    And the Account drop down  options should be displayed

      |Savings  |
      |Checking |
      |Loan     |
      |Credit   |
      |Card     |
      |Brokerage|


  Scenario: Transaction table
    Then the user clicks to Account	activity
    And the transactions table should have column names
      |Date       |
      |Description|
      |Deposit    |
      |Withdrawal |