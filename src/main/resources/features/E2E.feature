Feature: SauceDemo E2E Purchase Flow

  @regression
  Scenario: Complete purchase flow
    Given user is on saucedemo login page
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks login button
    Then user should see products page with title "Swag Labs"

    When user adds "Sauce Labs Backpack" to cart
    And user adds "Sauce Labs Onesie" to cart
    Then cart should show "2" items

    When user clicks cart icon
    Then cart page title should be "Your Cart"
    And "Sauce Labs Backpack" should be in cart
    And "Sauce Labs Onesie" should be in cart

    When user clicks checkout
    And user enters first name "Dinesh"
    And user enters last name "E"
    And user enters postal code "658963"
    And user clicks continue

    Then checkout overview should be displayed
    When user clicks finish
    Then success message should be "Thank you for your order!"
    Then user clicks generate pdf button