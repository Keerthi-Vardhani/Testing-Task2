
Feature: This feature will test a LogIn and LogOut functionality

Scenario Outline: Login with valid Credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>" Keeping case as Valid
    Then User should get logged in
    And Message displayed Login Successfully
Examples:   
    | username       | password | Case      |
    | abc@gmail.com  | 12345    | Valid     |
 

Scenario Outline: Login with Invalid Credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>" Keeping case as InValid
    Then user will be asked to go back to login page
    And Provide correct credentials

Examples:
    | username       | password | Case      |
    | abc1@gmail.com | dfsd2    | InValid   |
