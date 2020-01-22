#Author: Yan Yang
#Feature Summary: TradeMe channel test feature definition test including product export,update product export and inactive V5 contextual

@TradeMe
Feature: TradeMe channel test for V5-Contextual


  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting8@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as TradeMeTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual @New
  Scenario: test channel exports new products
    Given CommerceConnect Trademe channel 'TradeMe'
    When trigger Export job 92
    Then Filter value in External code and Type as 'Product', 1 new items should be Added
    Then Filter value in External code and Type as 'Variant', 6 new items should be Added
    When trigger Export job 93
    Then Filter value in External code and Type as 'Image', 9 new items should be Added

  @V5 @Contextual @Update
  Scenario: test channel exports product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 92
    Then Filter value in External code and Type as 'Product', 1 new items should be Added
    Then Filter value in External code and Type as 'Variant', 2 new items should be Added


  @V5 @Contextual @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 92
    Then Filter value in External code and Type as 'Product', 1 new items should be Deleted
    Then Filter value in External code and Type as 'Variant', 6 new items should be Deleted
    Then Filter value in External code and Type as 'Image', 9 new items should be Deleted


  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
