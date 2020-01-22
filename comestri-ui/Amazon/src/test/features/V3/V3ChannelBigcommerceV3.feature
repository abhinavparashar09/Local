#Author: Nikhil Kumar
#Feature Summary:

@BigCommerceV3
Feature: BigCommerceV3 channel test for V3

  @V3 @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "ian.testing2@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for Bigcommerce channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test Bigcommerce channel export new products
    Given CommerceConnect Bigcommerce channel 'Bigcommerce_BigBang'
    When trigger Export job 17
    And In Export Items tab, set filter values using these product indexes
      | 0 | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in External code and Type as '', 7 new items should be Added

  @V3
  Scenario: test Bigcommerce channel export product update
    Given V3 product is updated including description
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 17
    And In Export Items tab, set filter values using these product indexes
      | 0 | 6 | 7 | 8 |
    Then Filter values in External code and Type as '', 4 new items should be Added

  @V3
  Scenario: test Bigcommerce channel delisting deleted products
    Given V3 product with index of 7 is deleted from PIM
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 17
    Then In Export Items tab, set filter values using these product indexes
      | 7 |
    Then Filter value in External code and Type as 'Sku', 1 new items should be Deleted

  @V3
  Scenario: test Bigcommerce channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 17
    Then In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter value in External code and Type as 'Product', 1 new items should be Added
    Then In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 8 |
    Then Filter values in External code and Type as 'Sku', 5 new items should be Deleted

  @V3 @Order
  Scenario: test Bigcommerce channel order import
    Given BigCommerce Admin page URL: "http://bigbang3.mybigcommerce.com" and username  and password vmshcxy41h to sign in
    When a new BigCommerce order is generated
    And import order job is triggered in channel
    Then this BigCommerce order should be imported and job result is Success in Order Manager

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place


