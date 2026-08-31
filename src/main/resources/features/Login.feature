Feature: SauceDemo Login

  Background:
    Given user is on saucedemo login page

  @smoke @regression
  Scenario: Valid login with correct credentials
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks login button
    Then user should see products page with title "Swag Labs"

  @regression
  Scenario: Invalid login with wrong credentials
    When user enters username "wrong_user"
    And user enters password "wrong_pass"
    And user clicks login button
    Then user should see error message