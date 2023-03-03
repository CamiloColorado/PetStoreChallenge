@Sanity
Feature: Store operations Sanity

  Background:
    Given a new order for a pet
    When I place the order in inventory
    Then the status code is 200
    And the schema "orderSchema.json" is correct

  Scenario: Get pet inventory by status
    When I look for the pet inventory
    Then the status code is 200
    And the schema "orderInventorySchema.json" is correct

  Scenario: Find order by id
    When I look for the order id
    Then the status code is 200
    And the schema "orderSchema.json" is correct

  Scenario: Delete order by id
    When I delete the order by id
    Then the status code is 200