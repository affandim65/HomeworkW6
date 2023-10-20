Feature: add item product to cart
  Scenario: add product to cart
    Given list product page
    When click button add to cart
    And click cart icon
    Then cart page show the choosen product
