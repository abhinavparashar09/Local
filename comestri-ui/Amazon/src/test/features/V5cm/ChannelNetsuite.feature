#Author: Yan Yang
#Feature Summary: NetSuite channel test including one-level product import and order export

@NetSuite
Feature: NetSuite channel test for V5-Contextual

  @Start
  Scenario: CommerceConnect login
    Given User navigate to homepage of Comestri
    When user logged in using username as "iantesting5@fusionfactory.com" and password as "Fusion123"
    Then User should see homepage
    And browser's URL should be "https://staging-product.commerceconnect.co/"


  @ProductImport
  Scenario: test NetSuite channel product import
    Given CommerceConnect NetSuite channel 'NetSuite'
    And NetSuite Admin page URL: https://system.na0.netsuite.com/app/common/item/item.nl?id=504&e=T&whence= and username ming.chen@fusionfactory.com and password Feb12th2019 to sign in
    When NetSuite product 504 and 502 are updated
    And import product job is triggered in channel
    Then Job result is Success in Product Manager and products 669 and 668 should get the updated value in PIM Version5

  @OrderExport
  Scenario: test NetSuite channel order export
    Given a mock ebay order is generated for iantesting5
    And mock new order is imported
    And Order Heartbeat is triggered and wait 120 seconds
    When trigger Export job 6
    Then In Export Items tab, filter by orderID with prefix ''
    Then Filter value in External code and Type as 'Order data', 1 new items should be Added

  @last
  Scenario: TearDown
    Given User has completed Test
    When Test completed
    Then log will be in place