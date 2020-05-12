@login
  Feature: Login
    As user, I want to be able to login with username and password

    Background: open login page
      Given user is on the login page

      Scenario: Login as authorized user and verify that Account summary page is displayed
        When user logs in with valid credentials
        Then Account summary page should be displayed

    @login_with_wrong_info
    Scenario: Users with wrong/blank username or wrong/blank password should not be able to login
      When user tries to log in with invalid information
      Then error message "Login and/or password are wrong." should be displayed
