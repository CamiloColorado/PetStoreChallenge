@Sanity
Feature: Pet operations Sanity

  Background:
    Given a new pet
    When I add the new pet
    Then the status code is 200
    And the schema "petSchema.json" is correct

  Scenario: Update an existing pet
    When I update the new pet
    Then the status code is 200
    And the schema "petSchema.json" is correct

  Scenario Outline: Find pets by status
    When I look for the pet by status "<Status>"
    Then the status code is 200
    And the schema "petByStatusSchema.json" is correct

    Examples:
      | Status    |
      | available |
      | pending   |
      | sold      |

  Scenario: Find pets by tags
    When I look for the pet by tag "Test"
    Then the status code is 200
    And the schema "petByStatusSchema.json" is correct

  Scenario: Find pets by id
    When I look for the pet by id
    Then the status code is 200
    And the schema "petSchema.json" is correct

  Scenario: Update an existing pet by form data
    When I update by "complete" form data the new pet
    Then the status code is 200
    And the schema "petSchema.json" is correct

  Scenario: Delete an existing pet
    When I delete the new pet
    Then the status code is 200

  Scenario: Upload pet image
    When I upload a pet image
    Then the status code is 200
