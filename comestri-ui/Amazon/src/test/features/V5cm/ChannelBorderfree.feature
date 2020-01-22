#Author: Yan Yang
#Feature Summary: Borderfree channel test feature definition

@Borderfree
Feature: The Borderfree channel test for V5-Contextual

# V5 contextual channel
  @V5 @Contextual @Start
  Scenario: Successful Login with Valid Credentials
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as BorderfreeTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual
  Scenario: verify new channel products content
    Given CommerceConnect Borderfree channel 'Borderfree Contextual'
    Given wait 30 seconds to proceed
    When In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter by Code and Type as 'Product', 6 new items should be Active
    Then Filter by Display name and Type as 'Price', 6 new items should be Active
    Then Price Item should be as expected PriceContent

  @V5 @Contextual
  Scenario Outline: test channel export new products,export includes Product and Price
    When trigger Export job <jobID>
    Given wait 5 seconds to proceed
    Examples:
      | jobID | jobType | filterName  | numberOfItem | result |
      | 276   | Product | code        | 6            | Active |
      | 275   | Price   | displayname | 6            | Active |

  @V5 @Contextual
  Scenario: test channel export product price update
    Given V5 product Prices are updated
    And Product Heartbeat is triggered and wait 120 seconds
    Then Filter by Code and Type as 'Product', 3 new items should be Active
    Then Filter by Display name and Type as 'Price', 3 new items should be Active
    Then Price Item should be as expected updatedPriceContent

# @V5 @Contextual
#https://fusionfactory.atlassian.net/browse/CCD-2379
#Scenario: test channel delete product deactivation
#Given V5 product is delete from PIM
#And Product Heartbeat is triggered and wait 90 seconds
#Then Filter code and Type as 'Product', 1 new items should be Inactive
#Then Filter displayname and Type as 'Price', 1 new items should be Inactive

  @V5 @Contextual
  Scenario: test channel missing fields deactivation
    Given V5 product Price is removed
    And Product Heartbeat is triggered and wait 120 seconds
    When In Export Items tab, set filter values using these product indexes
      | 6 | 7 | 8 |
    Then Filter by Code and Type as 'Product', 3 new items should be Inactive
    Then Filter by Display name and Type as 'Price', 3 new items should be Inactive

  @V5 @Contextual
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds
    When In Export Items tab, set filter values using these product indexes
      | 3 | 4 |
    Then Filter by Code and Type as 'Product', 2 new items should be Inactive

# @V5 @Contextual
#Scenario: test Price Item deactivation
#https://fusionfactory.atlassian.net/browse/CCD-2371
#If Product is inactive the price item should be inactive either 
#Then Filter displayname and Type as 'Price', 2 new items should be Inactive

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
