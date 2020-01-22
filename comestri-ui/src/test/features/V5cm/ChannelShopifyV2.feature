#Author: Yan Yang
#Feature Summary:

@Shopifyv2
Feature: Shopify V2 channel test for V5-Contextual

  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as Test
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual @New
  Scenario: test channel exports new products
    Given CommerceConnect Shopify v2 channel 'New Shopify Channel'
    Given wait 40 seconds to proceed
    When trigger chained5 Export job 379
    And In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter values in Code and Type as 'Product', 1 new items should be Added
    Then Filter values in Code and Type as 'Product image', 1 new items should be Added
    Then Filter values in Code and Type as 'Metafield', 1 new items should be Added
    And In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 6 new items should be Added
    And In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in Code and Type as 'Inventory', 6 new items should be Added


  @V5 @Contextual @Update
  Scenario: test channel exports product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 381
    And In Export Items tab, set filter values using these product indexes
      | 6 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 3 new items should be Added
    When trigger Export job 382
    And In Export Items tab, set filter values using these product indexes
      | 6 | 7 |
    Then Filter values in Code and Type as 'Inventory', 2 new items should be Added

  @V5 @Contextual @Delete
  Scenario: test channel delete sku
    Given V5 product with index of 6 is deleted from PIM
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 381
    Then In Export Items tab, set filter values using these product indexes
      | 6 |
    Then Filter value in Code and Type as 'Variant', 1 new items should be Deleted

  @V5 @Contextual @Delete
  Scenario: test channel delisting filtered out products
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 381
    Then In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 7 | 8 |
    Then Filter values in Code and Type as 'Variant', 5 new items should be Deleted
    When trigger Export job 379
    Then In Export Items tab, set filter values using these product indexes
      | 0 |
    Then Filter value in Code and Type as 'Product', 1 new items should be Deleted


  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
