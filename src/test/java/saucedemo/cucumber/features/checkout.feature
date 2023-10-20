Feature: checkout page
  Scenario: checkout cart
    Given product page
    When click the button add to cart
    And click iconcart
    And click checkout button
    Then show checkout page
    And input buyer data
    Then show checkout preview
    And click finish button
    Then finish

