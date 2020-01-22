#Author: Nikhil Kumar
#Feature: Advance Search Testing for V5 Version of Comestri
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)


@AdvanceSearch
Feature: Advance Search testing
  To test the functionality of Advance search

  @Start
  Scenario: Below are the common steps for each scenario
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  Scenario: Search by ID
    When  User click at Product manager
    And Click at the Manage product link
    And Click at Advance Search link
    And select search by Id from dropdown
    And enter search keyword as "24734"
    Then User should get some test results
    And Atleast one product should be displayed for valid search text


  Scenario: Search by Name
    When  User click at Product manager
    When Click at the Manage product link
    And Click at Advance Search link
    And search by Name by selecting filter 0 and enter search keyword as "SKYLERV5 215105Apr19 VEST"
    Then User should get some test results
    And Atleast one product should be displayed for valid search text


  Scenario: Search by Code
    When  User click at Product manager
    When Click at the Manage product link
    And Click at Advance Search link
    And search by Code by selecting filter 0 and enter search keyword as "skyler-145813Sep19-grey"
    Then User should get some test results
    And Atleast one product should be displayed for valid search text

  @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place








