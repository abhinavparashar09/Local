#Author: Nikhil Kumar
#Feature Summary:Product export, update export, deactivation by filter and deactivation by deletion for 2 modes of ebay channel

@Ebay
Feature: ebay channel test

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "ian.testing2@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for ebay channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test ebay channel (SKU as Variation) export new product
    Given CommerceConnect Ebay channel 'ebayTest'
    When trigger Export job 2
    Then Filter value in Display name and Type as 'Product', 1 new items should be Added

  @V3
  Scenario: test ebay channel (SKU As Item) export new products
    Given switch to Ebay channel 'ebaySKUAsItem'
    When trigger Export job 25
    Then Filter value in Display name and Type as 'Product', 6 new items should be Added

  @V3
  Scenario: test ebay channel (SKU As Item) export products update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 26
    Then Filter value in Display name and Type as 'Product', 3 new items should be Added

  @V3
  Scenario: test ebay channel (SKU as Variation) export product update
    Given switch to Ebay channel 'ebayTest'
    When trigger Export job 2
    Then Filter value in Display name and Type as 'Product', 1 new items should be Added

  @V3
  Scenario: test ebay channel (SKU As Item) delisting deleted products
    Given V3 product with index of 7 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds
    And switch to Ebay channel 'ebaySKUAsItem'
    When trigger Export job 25
    Then Filter value in Display name and Type as 'Product', 1 new items should be Ended

  @V3
  Scenario: test ebay channel (SKU As Item) delisting deleted products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 25
    Then Filter value in Display name and Type as 'Product', 5 new items should be Ended

  @V3
  Scenario: test ebay channel (SKU as Variation) delisting filtered out product
    Given switch to Ebay channel 'ebayTest'
    When trigger Export job 2
    Then Filter value in Display name and Type as 'Product', 1 new items should be Ended

  @V3 @Order
  Scenario: test ebay channel order import
    Given ebay Admin page URL: "http://www.ebay.com.au" and username ian.hong@fusionfactory.com and password Fusion123 to sign in
    When a new ebay order is generated
    And import order job is triggered in channel
    Then this ebay order should be imported and job result is Success in Order Manager

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
