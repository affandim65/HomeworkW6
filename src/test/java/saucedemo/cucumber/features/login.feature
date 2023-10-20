Feature: login
  Scenario: success login
    Given halaman login sauce demo
    When input username
    And input password
    And click login button
    Then user in inventory page

  Scenario: failed login
    Given halaman login sauce demo
    When input username
    And input invalid password
    And click login button
    Then show error message