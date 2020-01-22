#Author: Yan Yang
#Feature Summary: Product export, update export, deactivation by filter and deactivation by deletion for 2 modes of ebay channel

@BigCommerceV3
Feature: BigCommerce channel test for V5-Contextual


  @V5 @Contextual @Start
  Scenario: Successful Login with Valid Credentials
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5
  Scenario: test product CSV upload
    Given product CSV for BigcommerceV3 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5
  Scenario: test Bigcommerce channel export new products
    Given CommerceConnect Bigcommerce v3 channel 'BigcommerceV3 Automation'
    And wait 90 seconds to proceed
    When trigger chained4 Export job 353
    And In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter values in Code and Type as 'Product', 1 new items should be Added
    And In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 6 new items should be Added

  @V5
  Scenario: test Bigcommerce channel export product update
    Given V5 product is updated including description
    And Product Heartbeat is triggered and wait 180 seconds
    When trigger Export job 353
    And In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter values in Code and Type as 'Product', 1 new items should be Added
    When trigger Export job 356
    And In Export Items tab, set filter values using these product indexes
      | 6 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 3 new items should be Added

  @V5 @Delete
  Scenario: test Bigcommerce channel delisting deleted products
    Given V5 product with index of 6 is deleted from PIM
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 356
    Then In Export Items tab, set filter values using these product indexes
      | 6 |
    Then Filter value in Code and Type as 'Variant', 1 new items should be Deleted

  @V5
  Scenario: test Bigcommerce channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 240 seconds
    When trigger Export job 353
    Then In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter value in Code and Type as 'Product', 1 new items should be Added
    When trigger Export job 356
    Then In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 5 new items should be Deleted

  @V5
  Scenario: test Bigcommerce V3 channel order import
    Given BigCommerce V3 Admin page URL: "http://comstriqa.mybigcommerce.com" and username  and password 2xvxp4ksy8 to sign in
    When a new BigCommerceV3 order is generated
    And import order job is triggered in channel
    Then this BigCommerce order should be imported and job result is Success in Order Manager

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
