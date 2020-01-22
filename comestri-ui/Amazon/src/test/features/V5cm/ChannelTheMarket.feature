#Author: Yan Yang
#Feature Summary:


@TheMarket
Feature: The Market channel test for V5-Contextual

  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test V5 product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as MarketTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual
  Scenario: verify V5 new channel products content
    Given CommerceConnect TheMarket channel 'The market testing'
    When trigger Export job 336
    Then Filter value in External code and Type as 'Product', 6 new items should be Added
    When trigger Export job 350
    Then Filter value in External code and Type as 'Inventory', 6 new items should be Added
    When trigger Export job 337
    Then Filter value in External code and Type as 'Image', 3 new items should be Added

  @V5 @Contextual
  Scenario: test V5 channel exports product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 336
    Then Filter value in External code and Type as 'Product', 3 new items should be Added
    When trigger Export job 350
    Then Filter value in External code and Type as 'Inventory', 2 new items should be Added

  @V5 @Contextual @Delete
  Scenario: test V5 channel delete product deactivation
    Given V5 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 336
    Then Filter value in External code and Type as 'Product', 1 new items should be Disabled

  @V5 @Contextual
  Scenario: test V5 channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 336
    Then Filter value in External code and Type as 'Product', 6 new items should be Disabled

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
