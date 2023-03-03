@Current
Feature: Store validations

  Background:
    Given a new order for a pet
    When I place the order in inventory
    Then the status code is 200

  Scenario: Find order by wrong id
    And I set the value "123456789" in the "orderId" for the order
    When I look for the order id
    Then the status code is 404

  Scenario: Delete order by wrong id
    And I set the value "123456789" in the "orderId" for the order
    When I delete the order by id
    Then the status code is 404
