#Author: Nikhil Kumar
#Feature Summary:TradeMe channel test feature definition

@TradeMe
Feature: TradeMe channel test including product export,update product export and inactive on V3 and V5 contextual

  @V3 @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV3 is prepared
    And product template brand is set as TrademeTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3 @New
  Scenario: test channel exports new products
    Given CommerceConnect Trademe channel 'TradeMe New'
    When trigger Export job 180
    Then Filter value in External code and Type as 'Product', 1 new items should be Added
    Then Filter value in External code and Type as 'Variant', 6 new items should be Added
    When trigger Export job 181
    Then Filter value in External code and Type as 'Image', 6 new items should be Added

  @V3 @Update
  Scenario: test channel exports product update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 180
    Then Filter value in External code and Type as 'Product', 1 new items should be Added
    Then Filter value in External code and Type as 'Variant', 2 new items should be Added

# Not support delete one variant
  @V3 @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 180
    Then Filter value in External code and Type as 'Product', 1 new items should be Deleted
    Then Filter value in External code and Type as 'Variant', 6 new items should be Deleted
#Do not need to export image, deleted with the product
#When trigger Export job 181
    Then Filter value in External code and Type as 'Image', 6 new items should be Deleted

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
