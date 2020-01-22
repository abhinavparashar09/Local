#Author: Nikhil Kumar

@Login
Feature: To check the functionality of Login to Comestri portal
  This feature will be used to test login to admin portal of Comestri

  @Start
  Scenario: Successful Login with Valid Credentials
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place






