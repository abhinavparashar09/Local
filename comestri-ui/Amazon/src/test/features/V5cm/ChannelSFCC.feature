#Author: Yan Yang
#Feature Summary: SFCC channel test feature definition

@SFCC
Feature: SFCC channel test for V5-Contextual

  @V5 @Start @Contextual
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for SFCC V5 channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual
  Scenario: test SFCC channel export new products
    Given CommerceConnect SFCC channel 'SFCC ContextualMapping'
    And wait 90 seconds to proceed

  @V5 @Contextual
  Scenario Outline: export includes Product, Site Category, Price and Inventory
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType       | filterName    | numberOfItem | result |
      | 82    |               | Display name  | 9            | Added  |
      | 83    | Site category | External code | 1            | Added  |
      | 84    | Price         | External code | 12           | Added  |
      | 85    | Inventory     | External code | 12           | Added  |

  @V5 @Contextual
  Scenario: test contextual channel export product update
    Given V5 product is updated including description
    And Product Heartbeat is triggered and wait 120 seconds

  @V5 @Contextual
  Scenario Outline: export includes price update, product update and inventory update
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result |
      | 88    | Price     | External code | 3            | Added  |
      | 86    |           | Display name  | 7            | Added  |
      | 89    | Inventory | External code | 4            | Added  |

  @V5 @Delete @Contextual
  Scenario: test channel export sku delete
    Given V5 product with index of 3 is deleted from PIM
    And Product Heartbeat is triggered and wait 150 seconds

  @V5 @Delete @Contextual
  Scenario Outline: export includes product delete, price delete and inventory delete
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType   | filterName    | numberOfItem | result  |
      | 92    |           | Display name  | 1            | Deleted |
      | 94    | Price     | External code | 2            | Deleted |
      | 95    | Inventory | External code | 2            | Deleted |

  @V5 @Contextual
  Scenario: test contextual channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    #Given switch to SFCC channel 'SFCC'

  @V5 @Contextual
  Scenario Outline: export includes product delete, site category delete, price delete and inventory delete
    When trigger Export job <jobID>
    Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType       | filterName    | numberOfItem | result  |
      | 92    |               | Display name  | 8            | Deleted |
      | 93    | Site category | External code | 1            | Deleted |
      | 94    | Price         | External code | 10           | Deleted |
      | 95    | Inventory     | External code | 10           | Deleted |

  @V5 @Order
  Scenario: test SFCC channel order import
    Given SFCC Admin page URL: "http://fusionfactory02-tech-prtnr-ap01-dw.demandware.net/s/SiteGenesis/mens/clothing/dress%20shirts/demandware_115426Nov18_green_large.html?lang=default" and username anything and password anything to sign in
    When a new SFCC order is generated
    And import ocapi_order job is triggered in channel
    Then this SFCC order should be imported and job result is Success in Order Manager

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
