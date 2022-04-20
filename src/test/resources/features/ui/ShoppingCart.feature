@sample @smoke
#@manual-result:passed
Feature: User navigates to shopping cart and add an item to checkout

  Background: User launches the web application
    Given the user is on login page

  @demo @debug
  Scenario Outline: User1 login with validate credentials, select an item and verify shopping cart and logout
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    And the user clicks add to cart button randomly on the products page to an item
    And the user clicks shopping cart icon and clicks checkout button
#    And the user enter details and click continue to final checkout page
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password |
      | test_user1 |  pass1   |
      | test_user2 |  pass2   |
      | test_user3 |  pass3   |

  @demo
  Scenario Outline: User2 login with validate credentials, select an item and verify shopping cart and logout
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    And the user clicks add to cart button randomly on the products page to an item
    And the user clicks shopping cart icon and clicks checkout button
#    And the user enter details and click continue to final checkout page
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password |
      | test_user1 |  pass1   |
      | test_user2 |  pass2   |
      | test_user3 |  pass3   |