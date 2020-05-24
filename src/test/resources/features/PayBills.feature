@payBills
Feature: Pay Bills

  Background:
    Given user is on the login page
    When user logs in with valid credentials
    Then user navigates to "Pay Bills"
    Then page title should be "Zero - Pay Bills"

  Scenario: User completes a successful pay operation
    And user should pay saved payee with following:
      | Payee       | Bank of America  |
      | Account     | Loan             |
      | Amount      | 5000             |
      | Date        | 2021-05-01       |
      | Description | Description      |
    And user should click pay button
    Then success "The payment was successfully submitted." should be displayed

  Scenario: User tries to make a payment without entering the amount or date
    And user puts following:
      | Payee       |Bank of America   |
      | Account     | Savings          |
      | Description | Description      |
    And user should click pay button
    Then "Please fill out this field." should be displayed