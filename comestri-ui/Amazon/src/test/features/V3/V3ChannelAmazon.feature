#Author: Nikhil Kumar
#Feature Summary:

@Amazon
Feature: Amazon channel test for V3

  @V3 @Start @test
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for Amazon channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test channel export new products
    Given CommerceConnect Amazon channel 'Amazon V3'
    When trigger Export job 70
    And In Export Items tab, set filter values using these product indexes
      | 0 | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in External code and Type as 'Product', 7 new items should be Added

  @V3
  Scenario: test channel export new inventory
    When trigger Export job 71
    And In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in External code and Type as 'Inventory', 6 new items should be Added

  @V3
  Scenario: test channel export new price
    When trigger Export job 72
    Then Filter values in External code and Type as 'Price', 6 new items should be Added

  @V3
  Scenario: test channel export new product image
    When trigger Export job 73
    Then Filter values in External code and Type as 'Productimage', 6 new items should be Added

  @V3
  Scenario: test channel export new relationship
    When trigger Export job 74
    Then Filter values in External code and Type as 'Relationship', 6 new items should be Added

  @V3
  Scenario: test channel export product update
    And V3 product is updated including description
    And Product Heartbeat is triggered and wait 90 seconds
    When trigger Export job 70
#Remove verification for Red Small, this product's EAN is not valid for updating product
#Only a set of EANs was valid for testing in amazon seller center
    And In Export Items tab, set filter values using these product indexes
      | 0 | 2 | 3 | 4 | 7 | 8 |
    Then Filter values in External code and Type as 'Product', 6 new items should be Added

  @V3
  Scenario: test channel export inventory update
    When trigger Export job 71
    And In Export Items tab, set filter values using these product indexes
      | 6 | 7 |
    Then Filter values in External code and Type as 'Inventory', 2 new items should be Added

  @V3
  Scenario: test channel export price update
    When trigger Export job 72
    And In Export Items tab, set filter values using these product indexes
      | 6 | 7 | 8 |
    Then Filter values in External code and Type as 'Price', 3 new items should be Added

  @V3
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 60 seconds
    When trigger Export job 70
    And In Export Items tab, set filter values using these product indexes
      | 0 | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter values in External code and Type as 'Product', 7 new items should be Deleted

  @V3 @last @test
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place