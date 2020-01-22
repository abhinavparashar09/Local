#Author: Yan Yang
#Feature Summary: #Magento1 channel test feature definition including product export,update product export and inactive on V5 contextual

@Magento1
Feature: Magento1 channel test in V5-Non_Contextual


  @V5 @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as Con
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @New
  Scenario: test channel exports new products
    Given CommerceConnect Magento channel 'Magento1'
    When trigger Export job 8
    Then Filter value in External code and Type as 'blank', 8 new items should be Added
    When trigger Export job 63
    And In Export Items tab, filter by code with prefix '%'
    Then Filter value in External code and Type as 'Price', 10 new items should be Added

  @V5 @Update
  Scenario: test channel exports product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 63
    Then Filter value in External code and Type as 'Price', 3 new items should be Added
#Magento1 V5 non contextual not support product stock export
#When trigger Export job 183
    When trigger Export job 8
    Then Filter value in External code and Type as 'Simple product', 2 new items should be Added

  @V5 @Delete
  Scenario: test channel delisting deleted products
    Given V5 product with index of 6 is deleted from PIM
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 8
    Then Filter value in External code and Type as 'Simple product', 1 new items should be Deleted

  @V5 @Delete
  Scenario: test channel delisting filtered out products
    Given each product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 8
    Then Filter value in External code and Type as 'Configurable product', 2 new items should be Deleted
    Then Filter value in External code and Type as 'Simple product', 5 new items should be Deleted
    And In Export Items tab, filter by code with prefix '%'
    Then Filter by External code and Type as 'Price', 10 new items should be Inactive


  @V5 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
