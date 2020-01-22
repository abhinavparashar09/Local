#Author: Yan Yang
#Feature Summary: Magento channel test feature definition including Magento2 export, order import and Magento1 Import, order export

@Magento
Feature: Magento channel test

  @Magento @Start
  Scenario: Below are the common steps for each scenario
    Given User navigate to homepage of Comestri
    When user logged in using username as "ian.testing1@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @Magento
  Scenario: test product CSV upload
    Given product CSV for Magento2 channel is prepared
#When product CSV file is uploaded
#Then user should be able to search this product in V3 mode

  @Magento @New
  Scenario: test channel exports new products
    Given CommerceConnect Magento2 channel 'Magento2Async'
#When trigger Export job 88
#Then Filter value in Display name and Type as 'Product', 8 new items should be Added 

#Scenario: test Magento2 channel product import
#TO Do: when updating product in Magento2 test server, the 'updated at' timestamp' doesn't change.
#       This needs Conrad to fix. Then this scenario can be completed.

  @Magento @OrderImport
  Scenario: test Magento2 channel order import
    Given Magento2 Admin page URL: "http://magento2.aws.fusionfactory.com/admin" and username commerceconnect and password fu510n!!! to sign in
    When a new Magento2 order is generated
    And import order job is triggered in channel
    Then this Magento2 order should be imported and job result is Success in Order Manager

  @Magento @OrderExport
  Scenario: test Magento2 channel order export
    Given a mock ebay order is generated for iantesting1
    And switch to Magento2 channel 'Magento2Async'
    And Order Heartbeat is triggered and wait 120 seconds
    When trigger Export job 96
    Then new order should be exported
    Then In Export Items tab, filter by orderID with prefix ''
    Then Filter value in External code and Type as 'Order data', 1 new items should be Added

  Scenario: test Magento1 channel product import
    Given Magento1 Admin page URL: "http://magento1.aws.fusionfactory.com/admin" and username user and password 1EszPzREfFAY to sign in
    When Magento1 product 79 and 250 are updated
    And switch to Magento channel 'MagentoTest'
    And import product job is triggered in channel
    Then Job result is Success in Product Manager and products 6 and 1125 should get the updated value in PIM Version3

  Scenario: test Magento1 channel order export
    Given Magento2 new order is imported
    When trigger Export job 32
    Then new order should be exported
    And In Export Items tab, filter by orderID with prefix ''
    Then Filter value in External code and Type as 'Order', 1 new items should be Added
    And contains orderline SKU Pink Scotch Plaid Shirt-M and Pink Scotch Plaid Shirt-S

  @Magento @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place

