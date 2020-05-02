@account
Feature: Account summary page
  Scenario:	Verify the title
    Given the user is logged in
    When user logs in with valid credentials
    Then the title should be Zero – Account summary


  Scenario: Account type
   # Given user is on the login page
    Given the user is logged in
    When user logs in with valid credentials
    Then the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Table must have columns
    Given the user is logged in
    When user logs in with valid credentials
    Then "Credit Accounts" table must have columns

      |Account    |
      |Credit Card|
      |Balance    |

