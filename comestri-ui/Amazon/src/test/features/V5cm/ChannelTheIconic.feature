#Author: Yan Yang
#Feature Summary:

@TheIconic
Feature: The Iconic channel test for V5-Contextual

  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting8@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test V5 product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as Nike
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual
  Scenario: test V5 contextual channel export new products
    Given CommerceConnect The Iconic channel 'Iconic'
    When trigger Export job 116
#    And In Export Items tab, set filter values using these product indexes
#      |2|3|4|6|7|8|
    Then Filter value in External code and Type as 'Product', 6 new items should be Added

  @V5 @Contextual
  Scenario: test V5 contextual channel export product update
    Given V5 product is updated excluding description
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 116
    Then Filter value in External code and Type as 'Product', 3 new items should be Added
    Then Filter value in External code and Type as 'Product image', 6 new items should be Added
#    And In Export Items tab, set filter values using these product indexes
#      |6|7|8|
#    Then Filter values in External code and Type as 'Product', 3 new items should be Added
#    And In Export Items tab, set filter values using these product indexes
#      |2|3|4|6|7|8|
#    Then Filter values in External code and Type as 'Product image', 6 new items should be Added


  @V5 @Contextual
  Scenario: test V5 contextual channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 70 seconds
    When trigger Export job 116
    Then Filter value in External code and Type as 'Product', 6 new items should be Disabled
       #And In Export Items tab, set filter values using these product indexes
    #  | 2 | 3 | 4 | 6 | 7 | 8 |
    #Then Filter values in External code and Type as 'Product', 6 new items should be Disabled

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
