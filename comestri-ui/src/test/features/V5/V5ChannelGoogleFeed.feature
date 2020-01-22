#Author: Yan Yang
#Feature Summary: GoogleFeed channel test feature definition

@GoogleFeed
Feature: The Google Feed channel test V5-Non_Contextual

# V5 Non contextual channel
  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5
  Scenario: test product CSV upload
    Given product CSV for Google Feed V5 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5
  Scenario: test channel export new products
    Given CommerceConnect Google Feed channel 'Google Feed V5'
    When trigger Export job 50
    Given wait 10 seconds to proceed
    When In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in Code and Item Type as 'Product', 6 new items should be Active

  @V5
  Scenario: test channel export product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 50
    Then Filter values in Code and Item Type as 'Product', 6 new items should be Active

  @V5
  Scenario: test channel delete product deactivation
    Given V5 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 100 seconds
    Then Filter values in Code and Item Type as 'Product', 1 new items should be Inactive

  @V5
  Scenario: test channel export product deactivation
    Given V5googlefeed product brand is changed to Performance
    And Product Heartbeat is triggered and wait 100 seconds
    Then Filter values in Code and Item Type as 'Product', 3 new items should be Inactive

  @V5 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place

