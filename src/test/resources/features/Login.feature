@run
Feature: User Login

  As a registered user
  I want to be able to log in to cianahealth
  So that I can access different features of cianahealth

  Scenario: User successfully logs in with valid credentials
    Given the user is on the login page
    When the user enters their valid username and password
    And clicks the Sign In button
    Then the user should be redirected to switch profile screen
    And the user should see a dashboard
