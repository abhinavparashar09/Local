#Author: Nikhil Kumar
#Feature Summary:

@TheMarket
Feature: The Market channel test in V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV3 is prepared
    And product template brand is set as MarketTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test channel export new products
    Given CommerceConnect TheMarket channel 'TheMarketChannelTest'
    And wait 120 seconds to proceed
    When trigger Export job 163
    Then Filter value in External code and Type as 'Product', 6 new items should be Added
    When trigger Export job 165
    Then Filter value in External code and Type as 'Inventory', 6 new items should be Added
    When trigger Export job 164
    Then Filter value in External code and Type as 'Image', 2 new items should be Added

  @V3
  Scenario: test channel exports product update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 163
    Then Filter value in External code and Type as 'Product', 3 new items should be Added
    When trigger Export job 165
    Then Filter value in External code and Type as 'Inventory', 2 new items should be Added

#  @V3 @Delete
#  Scenario: test channel delete product deactivation
#    Given V3 product with index of 2 is deleted from PIM
#    And Product Heartbeat is triggered and wait 90 seconds
#    When trigger Export job 163
#    Then Filter value in External code and Type as 'Product', 1 new items should be Disabled

  @V3
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 163
    Then Filter value in External code and Type as 'Product', 6 new items should be Disabled


  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
