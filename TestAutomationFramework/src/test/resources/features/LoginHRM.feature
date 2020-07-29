# The feature is for demo on Cucumber
# Author : Krishnendu
Feature: Orange HRM application Test

  Background: Application common steps
    Given Browser should be open with Orange HRM application

  @Smoke
  Scenario: To check the page title of Orange HRM application
  When User enters a valid username and password to the fields
  And Clicks on Login button
  Then User should be on Dashboard page
  @Smoke
  Scenario: To verify error message for Invalid Credentials
  When User enters an invalid "admin123" and "Admin" to the fields
  And Clicks on Login button
  Then User should get error message as "Invalid credentials"
  
  @Regression
  Scenario Outline: To verify error message for Invalid Credentials multiple times
    When User enters invalid "<username>" and "<password>" to the fields
    And Clicks on Login button
    Then User should get error message as "Invalid credentials"

    Examples: 
      |username  |password  |
      | admin123 | Admin    |
      | Admin    | Admin    |
      | admin    | admin    |
