#Author: Yan Yang
#Feature Summary: MySale channel test feature definition

@MySale
Feature: The MySale channel test for V5-Contextual

# V5 contextual channel

  @V5 @Start @Contextual
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

#Just need one inventory data
  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for MySale V5 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs


  @V5 @Contextual @New
  Scenario: test contextual channel export new products
    Given CommerceConnect MySale channel 'MySaleAutoamtionTesting'

  @V5 @Contextual @New
  Scenario Outline: verify export (product,sku,sku image,price and inventory)
    When trigger Export job <jobID>
    Given wait 5 seconds to proceed
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result |
      | 296   | Sku       | External code | 6            | Added  |
      | 297   | Sku image | External code | 6            | Added  |
      | 298   | Price     | External code | 6            | Added  |
      | 299   | Inventory | External code | 6            | Added  |

  @V5 @Contextual @New
  Scenario: verify channel price item content
    Then Channel MySale Item type 'Price' should be as expected content

  @V5 @Contextual @New
  Scenario: verify channel sku image item content
    Then Channel MySale Item type 'Sku image' should be as expected content

  @V5 @Contextual @New
  Scenario: verify channel inventory item content
    Then Channel MySale Item type 'Inventory' should be as expected content

  @V5 @Contextual @New
  Scenario: verify product export
    Given wait 30 seconds to proceed
    When trigger Export job 295
#Then Filter value in externalcode and Type as 'Product', 1 new items should be Added

  @V5 @Contextual @Update
  Scenario: test channel export product style level update
    Given V5 product is updated Style level desc
    And Product Heartbeat is triggered and wait 100 seconds
    Then Filter by External code and Type as 'Product', 1 new items should be Active

  @V5 @Contextual @Update
  Scenario: test channel export product sku level update
    Given V5 product is updated Sku level desc
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter by External code and Type as 'Sku', 1 new items should be Active

  @V5 @Contextual @Update
  Scenario: test channel image update
    Given V5 product image is removed
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter by External code and Type as 'Sku image', 3 new items should be Active
    Then Channel MySale Item type 'Sku image' should be as expected contentupdated

  @V5 @Contextual @Update
  Scenario: test channel price update
    Given V5 product Prices are updated
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter by External code and Type as 'Price', 3 new items should be Active
    Then Channel MySale Item type 'Price' should be as expected contentupdated

  @V5 @Contextual @Update
  Scenario: test channel inventory update
    Given V5 product Inventory is updated
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter by External code and Type as 'Inventory', 1 new items should be Active
    Then Channel MySale Item type 'Inventory' should be as expected contentupdated

  @V5 @Contextual
  Scenario: test product export
    Given CommerceConnect MySale channel 'MySaleAutoamtionTesting'
    When trigger Export job 295
    Then Filter value in External code and Type as 'Product', 1 new items should be Added

  @V5 @Contextual
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds

  @V5 @Contextual
  Scenario Outline: verify export (product and sku)
    Then Filter by External code and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobType | filterName    | numberOfItem | result   |
      | Product | External code | 1            | Inactive |
      | Sku     | External code | 6            | Inactive |

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
