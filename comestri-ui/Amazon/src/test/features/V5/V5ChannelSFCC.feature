#Author: Yan Yang
#Feature Summary:

@TheIconic
Feature: The Iconic channel test for V5-NON_Contextual

  @V5 @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5
  Scenario: test product CSV upload
    Given product CSV for SFCC V5 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5
  Scenario: test channel export new products
    Given CommerceConnect SFCC channel 'Demandware V5'

  @V5
  Scenario Outline: export includes Product, Site Category, Price and Inventory
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType       | filterName    | numberOfItem | result |
      | 26    |               | Display name  | 9            | Added  |
      | 29    | Site category | External code | 1            | Added  |
      | 59    | Price         | External code | 12           | Added  |
      | 58    | Inventory     | External code | 12           | Added  |


  @V5
  Scenario: test channel export product update
    Given V5 product is updated including description
    And Product Heartbeat is triggered and wait 120 seconds
    And switch to SFCC channel 'Demandware V5'

  @V5
  Scenario Outline: export includes price update, product update and inventory update
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result |
      | 77    | Price     | External code | 3            | Added  |
      | 30    |           | Display name  | 8            | Added  |
      | 62    | Inventory | External code | 4            | Added  |


  @V5 @Delete
  Scenario: test channel export sku delete
    Given V5 product with index of 3 is deleted from PIM
    And Product Heartbeat is triggered and wait 150 seconds
    And switch to SFCC channel 'Demandware V5'

  @V5 @Delete
  Scenario Outline: export includes product delete, price delete and inventory delete
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result  |
      | 79    |           | Display name  | 1            | Deleted |
      | 81    | Price     | External code | 2            | Deleted |
      | 61    | Inventory | External code | 2            | Deleted |


  @V5
  Scenario: test channel export product deactivation
    Given each product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    And switch to SFCC channel 'Demandware V5'

  @V5
  Scenario Outline: export includes product delete, site category delete, price delete and inventory delete
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType       | filterName    | numberOfItem | result  |
      | 79    |               | Display name  | 8            | Deleted |
      | 80    | Site category | External code | 1            | Deleted |
      | 81    | Price         | External code | 10           | Deleted |
      | 61    | Inventory     | External code | 10           | Deleted |


  @V5 @Order
  Scenario: test SFCC channel order import
    Given SFCC Admin page URL: "http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang=default" and username anything and password anything to sign in
    When a new SFCC order is generated
    And import ocapi_order job is triggered in channel
    Then this SFCC order should be imported and job result is Success in Order Manager


  @V5  @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
