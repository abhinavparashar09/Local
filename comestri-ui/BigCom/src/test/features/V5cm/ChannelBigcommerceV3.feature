#Author: Yan Yang
#Feature Summary: Product export, update export, deactivation by filter and deactivation by deletion for 2 modes of ebay channel

@BigCommerceV3
Feature: BigCommerce channel test for V5-Contextual


  @V5 @Contextual @Start
  Scenario: Successful Login with Valid Credentials
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual @last
    Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
