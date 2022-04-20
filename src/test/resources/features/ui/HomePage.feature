@sample @smoke
#@manual-result:passed
Feature: User launches the demo application and performs some user actions

  Background: User launches the web application
    Given the user is on login page

  @demo_user1
  Scenario Outline: User1 launches the web application to login with validate credentials, verifies home page and logout
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password |
      | test_user1 |  pass1   |
      | test_user2 |  pass2   |
      | test_user3 |  pass3   |

  @demo_user2
  Scenario Outline: User2 launches the web application to login with validate credentials, verifies home page and logout
    When the user enters valid username as <username> and valid password as <password>
    And the user verifies home page post login
    Then the user clicks burger menu and click logout link to terminate the user session
    Examples:
      | username   | password |
      | test_user1 |  pass1   |
      | test_user2 |  pass2   |
      | test_user3 |  pass3   |