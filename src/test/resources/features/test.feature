Feature: Test

  Scenario: Test 2
    Given user wants to open page
    When user choose category "laptops"
    And user see and click on product "Sony vaio i5"
    And user click on add to cart button
    And user navigate to "Home" page
    And user choose category "laptops"
    And user see and click on product "Dell i7 8gb"
    And user click on add to cart button
    And user navigate to "Cart" page
    And user verify cart contains "Sony vaio i5, Dell i7 8gb"
    And user place the order with data:
      |name|country|city|creditCard|month|year|
      |testing|denmark|copenhagen|1234567891012345|january|2022|
    Then purchase done successfully
