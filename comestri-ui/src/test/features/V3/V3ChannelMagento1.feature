#Author: Yan Yang
#Feature Summary: #Magento1 channel test feature definition including product export,update product export and inactive on V5 contextual

@Magento1
Feature: Magento1 channel test  for V3

  @V3 @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "ian.testing1@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V3
  Scenario: test product CSV upload
    Given product CSV for Magento2 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3 @New
  Scenario: test channel exports new products
    Given CommerceConnect Magento channel 'MagentoTest'
    When trigger Export job 4
    Then Filter value in External code and Type as 'blank', 7 new items should be Added
    When trigger Export job 120
    And In Export Items tab, filter by code with prefix '%'
    Then Filter value in External code and Type as 'Price', 14 new items should be Added

  @V3 @Update
  Scenario: test channel exports product update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 120
    Then Filter value in External code and Type as 'Price', 4 new items should be Added
    When trigger Export job 5
    Then Filter value in External code and Type as 'Simple product', 2 new items should be Added

#@V3 @Delete
#not support export delete yet
#Scenario: test channel delisting deleted products
#Given V3 product with index of 6 is deleted from PIM
#And Product Heartbeat is triggered and wait 100 seconds
#When trigger Export job 4
#Then Filter value in External code and Type as 'Simple product', 1 new items should be Deleted

  @V3 @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 4
    Then Filter value in External code and Type as 'Configurable product', 1 new items should be Deleted
    Then Filter value in External code and Type as 'Simple product', 5 new items should be Deleted
    And In Export Items tab, filter by code with prefix '%'
    Then Filter by External code and Type as 'Price', 12 new items should be Inactive

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
