#Author: Nikhil Kumar
#Feature Summary: SFCC channel test feature definition

@SFCC
Feature: SFCC channel test for V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V3
  Scenario: test product CSV upload
    Given product CSV for SFCC channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test channel export new products
    Given CommerceConnect SFCC channel 'Demardware'

  @V3 @New
  Scenario Outline: export includes Product, Site Category, Price and Inventory
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType       | filterName    | numberOfItem | result |
      | 30    |               | Display name  | 7            | Added  |
      | 31    | Site category | External code | 1            | Added  |
      | 32    | Price         | External code | 12           | Added  |
      | 33    | Inventory     | External code | 6            | Added  |

  @V3 @Update
  Scenario: test channel export product update
    Given V3 product is updated including description
    And Product Heartbeat is triggered and wait 90 seconds

  @V3 @Update
  Scenario Outline: export includes price update, product update and inventory update
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result |
      | 56    | Price     | External code | 3            | Added  |
      | 54    |           | Display name  | 7            | Added  |
      | 37    | Inventory | External code | 2            | Added  |

  @V3 @Delete
  Scenario: test channel export sku delete
    Given V3 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds

  @V3 @Delete
  Scenario Outline: export includes product delete, price delete and inventory delete
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result  |
      | 177   |           | Display name  | 1            | Deleted |
      | 68    | Price     | External code | 2            | Deleted |
      | 69    | Inventory | External code | 1            | Deleted |


  @V3 @Deactivate
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds

#  @V3 @Deactivate
#  Scenario Outline: export includes product delete, site category delete, price delete and inventory delete
#    When trigger Export job <jobID>
#    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
#    Examples:
#      | jobID | jobType       | filterName    | numberOfItem | result  |
#      | 177   |               | Display name  | 6            | Deleted |
#      | 67    | Site category | External code | 1            | Deleted |
#      | 68    | Price         | External code | 10           | Deleted |
#      | 69    | Inventory     | External code | 5            | Deleted |
#
  @V3 @Order
  Scenario: test SFCC channel order import
    Given SFCC Admin page URL: "http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang=default" and username anything and password anything to sign in
    When a new SFCC order is generated
    And import order job is triggered in channel
    Then this SFCC order should be imported and job result is Success in Order Manager

  @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
