#Author: Yan Yang
#Feature Summary: Catch channel test feature definition

@Catch
Feature: The Catch channel test for V5-Contextual


# V5 contextual channel
  @V5 @Contextual @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"

  @V5 @Contextual
  Scenario: test product CSV upload
    Given product CSV for Model ProductsTemplateV5 is prepared
    Given product template brand is set as Catch
    When product CSV file is uploaded
    Then user should be able to search this product in "V5" mode
    And get Product IDs

  @V5 @Contextual @New
  Scenario: verify new channel products content
    Given CommerceConnect Catch channel 'Catch it'
    And wait 60 seconds to proceed
    Given In Export Items tab, filter by productcode with prefix ''
    Then Filter by External code and Type as 'Product', 6 new items should be Active
    Then Filter by External code and Type as 'Offer', 6 new items should be Active

  @V5 @Contextual
  Scenario Outline: test channel export jobs work
    When trigger Export job <jobID>
    Examples:
      | jobID |
      | 189   |
      | 190   |
# update description,price and inventory, test product update and offer update
  @V5 @Contextual @Update
  Scenario: test channel export product update
    Given V5 product is updated including description
    And Product Heartbeat is triggered and wait 60 seconds
    Then Filter by External code and Type as 'Product', 6 new items should be Active
    Then Filter by External code and Type as 'Offer', 3 new items should be Active

  @V5 @Contextual
  Scenario: test channel offer deactivation
    Given V5 product Price is removed
    And Product Heartbeat is triggered and wait 90 seconds
#Then Filter External code and Type as 'Product', 6 new items should be Active
    Then Filter by External code and Type as 'Offer', 3 new items should be Inactive

  @V5 @Contextual
  Scenario: test channel delete product deactivation
    Given V5 product with index of 2 is deleted from PIM
    And Product Heartbeat is triggered and wait 90 seconds
    Then Filter by External code and Type as 'Product', 1 new items should be Inactive
    Then Filter by External code and Type as 'Offer', 1 new items should be Inactive

  @V5 @Contextual
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 90 seconds
# 5 inactive because one has already deleted
    Then Filter by External code and Type as 'Product', 5 new items should be Inactive

  @V5 @Contextual @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
