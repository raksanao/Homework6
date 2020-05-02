@login
Feature: Login
  As user, I want to be able to login with username and password


Background: open login page
  Given the user is logged in


  Scenario: Login  as authorized user and verify that account summary page should be displayed
    When user logs in with valid credentials
    Then account summary page should be	displayed


      Scenario: Users with wrong username or wrong password should not be able to login.
   Users with blank username or password should also not be able to login.
     When user tries to login with invalid information
      Then error message Login and or password are wrong should be displayed.
