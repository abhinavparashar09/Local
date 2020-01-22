#Author: yan.yang@fusionfactory.com
#Feature Summary:GoogleFeed channel test feature definition

@GoogleFeed
Feature: The Google Feed channel test for V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for GoogleFeed channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test channel export new products
    Given CommerceConnect Google Feed channel 'GoogleFeedForAutomation'
    When trigger Export job 168
    When In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in Code and Item Type as 'Product', 6 new items should be Active

  @V3
  Scenario: test channel export product update
    Given V3 product is updated including description
    And Product Heartbeat is triggered and wait 60 seconds
    When trigger Export job 168
    Then Filter values in Code and Item Type as 'Product', 6 new items should be Active

  @V3
  Scenario: test channel delete product deactivation
    Given V3 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds
    Then Filter values in Code and Item Type as 'Product', 1 new items should be Inactive

  @V3
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter values in Code and Item Type as 'Product', 6 new items should be Inactive

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place

