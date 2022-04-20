@sample
#@manual-result:passed
Feature: Verify error messages for invalid logins and data throughout the demo application

  Background: User verifies invalid logins and invalid data entries
    Given the user is on login page

  @sample_error
  Scenario Outline: User1 verifies invalid logins and invalid data entries
    When the user enters valid username as <username> and invalid password as <password>
    And the user verifies error message <error_text> on login page
    Examples:
      | username   | password | error_text      |
      | test_user4 | null     | error_msg_text1 |
      | test_user1 | null     | error_msg_text2 |

  @sample_error
  Scenario Outline: User2 logs in and verifies error message on the check out cart
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    And the user clicks add to cart button randomly on the products page to an item
    And the user clicks shopping cart icon and clicks checkout button
#    And the user clicks continue button without entering full <user_details> details
#    And the user verifies error message <error_text> on shopping cart page
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password | error_text      | user_details            |
      | test_user1 |  pass1   | error_msg_text3 | last_name, postal_code  |
      | test_user2 |  pass2   | error_msg_text4 | first_name, postal_code |
      | test_user1 |  pass3   | error_msg_text5 | first_name, last_name   |

  @sample_error
  Scenario Outline: User3 verifies invalid logins and invalid data entries
    When the user enters valid username as <username> and invalid password as <password>
    And the user verifies error message <error_text> on login page
    Examples:
      | username   | password | error_text      |
      | test_user4 | null     | error_msg_text1 |
      | test_user1 | null     | error_msg_text2 |

  @sample_error @debug
  Scenario Outline: User4 logs in and verifies error message on the check out cart
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    And the user clicks add to cart button randomly on the products page to an item
    And the user clicks shopping cart icon and clicks checkout button
#    And User clicks continue button without entering full <user_details> details
#    And User verifies error message <error_text> on shopping cart page
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password | error_text      | user_details            |
      | test_user1 |  pass1   | error_msg_text3 | last_name, postal_code  |
      | test_user2 |  pass2   | error_msg_text4 | first_name, postal_code |
      | test_user1 |  pass3   | error_msg_text5 | first_name, last_name   |
