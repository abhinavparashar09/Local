#Author: Nikhil Kumar
#Feature Summary:

@TheIconic
Feature: TheIconic test for V3

  @V3 @Start
  Scenario: CommerceConnect login V3
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting4@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @V3
  Scenario: Test V3 product CSV upload
    Given product CSV for The Iconic channel is prepared
    When product CSV file is uploaded
    Then user should be able to search this product in "V3" mode
    And get Product IDs

  @V3
  Scenario: Test V3 channel export new products
    Given CommerceConnect The Iconic channel 'TheIconic'
    When trigger Export job 23
    And In Export Items tab, filter by ID with prefix '%'
    Then Filter value in External code and Type as 'Product', 6 new items should be Added

  @V3
  Scenario: Test V3 channel export product update
    Given V3 product is updated excluding description
    And Product Heartbeat is triggered and wait 60 seconds
    When trigger Export job 23
    And In Export Items tab, filter by ID with prefix '%'
    Then Filter value in External code and Type as 'Product', 3 new items should be Added
    And Filter value in External code and Type as 'Product image', 6 new items should be Added

  @V3
  Scenario: Test V3 channel export product deactivation
    Given style product brand is changed to Performance
    And Product Heartbeat is triggered and wait 60 seconds
    When trigger Export job 23
    And In Export Items tab, filter by ID with prefix '%'
    Then Filter value in External code and Type as 'Product', 6 new items should be Disabled

  @V3 @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place
