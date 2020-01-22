#Author: Nikhil Kumar
#Feature Summary:Facebook channel test feature definition

@Facebook
Feature: Facebook channel test for V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V3
  Scenario: test product CSV upload
    Given product CSV for Facebook channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: test channel export new products
    Given CommerceConnect Facebook channel 'Facebook V3 Display'
    When trigger Export job 95
    And In Export Items tab, filter by ID with prefix ''
    Then Filter value in Code and Type as 'Product', 6 new items should be Added

  @V3
  Scenario: test channel export product update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 95
    Then Filter value in Code and Type as 'Product', 3 new items should be Added

  @V3
  Scenario: test channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 120 seconds
    When trigger Export job 95
    Then Filter value in Code and Type as 'Product', 6 new items should be Deleted

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
