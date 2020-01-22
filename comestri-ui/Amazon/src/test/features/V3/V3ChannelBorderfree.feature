#Author: Yan Yang
#Feature Summary: Borderfree channel test feature definition

@Borderfree
Feature: The Borderfree channel test for V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "ian.testing2@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V3
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV3 is prepared
    Given product template brand is set as BorderfreeTest
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: verify new channel products content
    Given CommerceConnect Borderfree channel 'Borderfree New'
    When In Export Items tab, set filter values using these product indexes
      | 2 | 3 | 4 | 6 | 7 | 8 |
    Then Filter by Code and Type as 'Product', 6 new items should be Active
    Then Filter by Display name and Type as 'Price', 6 new items should be Active
    Then Price Item should be as expected PriceContent

  @V3
  Scenario Outline: test channel export new products,export includes Product and Price
    When trigger Export job <jobID>
#Then Filter value in <filterName> and Type as '<jobType>', <numberOfItem> new items should be <result>
    Examples:
      | jobID | jobType | filterName   | numberOfItem | result |
      | 108   | Product | Code         | 6            | Active |
      | 130   | Price   | Display name | 6            | Active |

  @V3
  Scenario: test channel export product price update
    Given V3 product Prices are updated
    And Product Heartbeat is triggered and wait 90 seconds
    Then Filter by Code and Type as 'Product', 3 new items should be Active
    Then Filter by Display name and Type as 'Price', 3 new items should be Active
    Then Price Item should be as expected updatedPriceContent

  @V3
  Scenario: test channel delete product deactivation
    Given V3 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds
    When In Export Items tab, set filter values using these product indexes
      | 2 |
    Then Filter by Code and Type as 'Product', 1 new items should be Inactive

  @V3
  Scenario: test channel missing fields deactivation
    Given V3 product Price is removed
    And Product Heartbeat is triggered and wait 90 seconds
    When In Export Items tab, set filter values using these product indexes
      | 6 | 7 | 8 |
    Then Filter by Code and Type as 'Product', 3 new items should be Inactive
    Then Filter by Display name and Type as 'Price', 3 new items should be Inactive

  @V3
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds
    When In Export Items tab, set filter values using these product indexes
      | 3 | 4 |
    Then Filter by Code and Type as 'Product', 2 new items should be Inactive

#@V3 
#Scenario: test Price Item deactivation
#If Product is inactive the price item should be inactive either 
#Then Filter displayname and Type as 'Price', 2 new items should be Inactive

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place

