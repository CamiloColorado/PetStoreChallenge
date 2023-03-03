@Current
Feature: User validations

  Background:
    Given a new user
    When I create the new user
    Then the status code is 200

  Scenario Outline: Logs user into the system with wrong a "<Field>"
    And I change the "<Field>" for the user
    When I login into the system with the new user
    Then the status code is 400

    Examples:
      | Field                 |
      | username              |
      | password              |
      | username and password |

  Scenario: Get user by a wrong username
    And I change the "username" for the user
    When I look for the new user by username
    Then the status code is 404

  Scenario: Update user by a wrong username
    And I change the "username" for the user
    When I update the user by the username
    Then the status code is 404

  Scenario: Delete user by a wrong username
    And I change the "username" for the user
    When I delete the user by the username
    Then the status code is 404
