#Author: Yan Yang
#Feature Summary: #Oro channel test feature definition including product export,update product export and inactive

@Oro
Feature: Oro channel test for V5-Contextual

  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as OroTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual @New
  Scenario: test channel exports new products
    Given CommerceConnect OroCommerce channel 'orocommercechannel'
    When trigger Export job 131
    Then Filter value in External code and Type as 'Configurable product', 2 new items should be Added
    Then Filter value in External code and Type as 'Simple product', 6 new items should be Added
#When trigger Export job 142
#Then Filter value in External code and Type as 'Price', 7 new items should be Added
#When trigger Export job 143
#Then Filter value in External code and Type as 'Image', 8 new items should be Added
#When trigger Export job 144
#Then Filter value in External code and Type as 'Inventory', 8 new items should be Added
#When trigger Export job 145
#Then Filter value in External code and Type as 'Variantlink', 6 new items should be Added
 
#need to export the product again to export other channel items
  @V5 @Contextual @Update
  Scenario: test channel exports product update
    Given V5 product is updated including description
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 131
    Then Filter value in External code and Type as 'Configurable product', 2 new items should be Added
    Then Filter value in External code and Type as 'Simple product', 6 new items should be Added
    When trigger Export job 142
    Then Filter value in External code and Type as 'Price', 7 new items should be Added
    When trigger Export job 143
    Then Filter value in External code and Type as 'Image', 8 new items should be Added
    When trigger Export job 144
    Then Filter value in External code and Type as 'Inventory', 8 new items should be Added
    When trigger Export job 145
    Then Filter value in External code and Type as 'Variantlink', 6 new items should be Added

#not support delete sku
#@V5 @Contextual @Delete
#Scenario: test channel delete sku
#Given V5 product with index of 6 is deleted from PIM
#And Product Heartbeat is triggered and wait 120 seconds
#When trigger Export job 131
#Then Filter value in External code and Type as 'Simple product', 1 new items should be Deleted
#Then Filter value in External code and Type as 'Price', 2 new items should be Deleted
#Then Filter value in External code and Type as 'Image', 1 new items should be Deleted
#Then Filter value in External code and Type as 'Inventory', 2 new items should be Deleted
#Then Filter value in External code and Type as 'Variantlink', 1 new items should be Deleted

  @V5 @Contextual @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 131
    Then Filter value in External code and Type as 'Configurable product', 2 new items should be Deleted
    Then Filter value in External code and Type as 'Simple product', 6 new items should be Deleted
    Then Filter value in External code and Type as 'Price', 7 new items should be Deleted
    Then Filter value in External code and Type as 'Image', 8 new items should be Deleted
    Then Filter value in External code and Type as 'Inventory', 8 new items should be Deleted
    Then Filter value in External code and Type as 'Variantlink', 6 new items should be Deleted

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
