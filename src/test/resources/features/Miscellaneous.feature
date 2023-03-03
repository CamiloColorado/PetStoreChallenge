@Current
Feature: Miscellaneous  validations

  Scenario: Validate user update flow
    Given a new user
    When I create the new user
    And I look for the new user by username
    And I change the "username" for the user
    When I update the user by the username
    And I look for the new user by username
    Then the status code is 200

  Scenario: Validate user deletion flow
    Given a new user
    When I create the new user
    And I delete the user by the username
    And I look for the new user by username
    Then the status code is 404

  Scenario Outline: Validate the store inventory after place an order
    When I look for the pet inventory
    And I save the original number of orders
    Given a new order for a pet
    And I set the value "<Status>" in the "status" for the order
    When I place the order in inventory
    And I look for the pet inventory
    Then the number of "<Status>" orders must "increase"

    Examples:
      | Status    |
      | approved  |
      | placed    |
      | delivered |

  Scenario Outline: Validate the store inventory after delete an order
    Given a new order for a pet
    And I set the value "<Status>" in the "status" for the order
    When I place the order in inventory
    And I look for the pet inventory
    And I save the original number of orders
    When I delete the order by id
    And I look for the pet inventory
    Then the number of "<Status>" orders must "decrease"

    Examples:
      | Status    |
      | approved  |
      | placed    |
      | delivered |

  Scenario: Validate order deletion flow
    Given a new order for a pet
    When I place the order in inventory
    And I delete the order by id
    And I look for the order id
    Then the status code is 404

  Scenario: Validate pet update flow
    Given a new pet
    When I add the new pet
    And I look for the pet by id
    And I change the "petId" for a pet
    When I update the new pet
    And I look for the pet by id
    Then the status code is 200

  Scenario: Validate pet deletion flow
    Given a new pet
    When I add the new pet
    And I delete the new pet
    And I look for the pet by id
    Then the status code is 404