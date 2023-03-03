@Sanity
Feature: User operations Sanity

  Background:
    Given a new user
    When I create the new user
    Then the status code is 200
    And the schema "userSchema.json" is correct

  Scenario: Create list of users
    When I create a list of users
    Then the status code is 200
    And the schema "userListSchema.json" is correct

  Scenario: Logs user into the system
    When I login into the system with the new user
    Then the status code is 200

  Scenario: Logs user out the system
    When I logout from the system with the new user
    Then the status code is 200

  Scenario: Get user by username
    When I look for the new user by username
    Then the status code is 200
    And the schema "userSchema.json" is correct

  Scenario: Update user by username
    When I update the user by the username
    Then the status code is 200
    And the schema "userSchema.json" is correct

  Scenario: Delete user by username
    When I delete the user by the username
    Then the status code is 200