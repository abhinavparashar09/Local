#Author: Yan Yang
#Feature Summary: #Magento2 channel test feature definition including product export,update product export and inactive

@Magento2
Feature: Magento2 channel test for V5-Contextual


  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting8@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as Magento2Test
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual @New
  Scenario: test channel exports new products
    Given CommerceConnect Magento2 channel 'magento2'
    When trigger Export job 22
    Then Filter value in External code and Type as 'blank', 8 new items should be Added
    When trigger Export job 25
    And In Export Items tab, filter by code with prefix '%'
    Then Filter value in External code and Type as 'Price', 8 new items should be Added

  @V5 @Contextual @Update
  Scenario: test channel exports product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 25
    Then Filter value in External code and Type as 'Price', 4 new items should be Added
    When trigger Export job 26
    Then Filter value in External code and Type as 'Simple product', 2 new items should be Added

  @V5 @Contextual @Delete
  Scenario: test channel delisting deleted products
    Given V5 product with index of 6 is deleted from PIM
    And Product Heartbeat is triggered and wait 70 seconds
#When trigger Export job 22
    Then Filter by External code and Type as 'Simple product', 1 new items should be Inactive

  @V5 @Contextual @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
#When trigger Export job 22
    Then Filter by External code and Type as 'Configurable product', 2 new items should be Inactive
    Then Filter by External code and Type as 'Simple product', 6 new items should be Inactive
# Price item stay active in magento2
#And In Export Items tab, filter by code with prefix '%'
#Then Filter by External code and Type as 'Price', 8 new items should be Inactive


  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
