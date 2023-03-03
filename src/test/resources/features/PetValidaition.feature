@Current
Feature: Pet validations

  Background:
    Given a new pet
    When I add the new pet
    Then the status code is 200

  Scenario: Update a non existing pet
    And I change the "petId" for a pet
    When I update the new pet
    Then the status code is 404

  Scenario: Find pets by invalid status
    When I look for the pet by status "sick"
    Then the status code is 400

  Scenario: Find pets by invalid tags
    When I look for the pet by tag "sick"
    Then the status code is 400

  Scenario: Find pets by wrong id
    And I change the "petId" for a pet
    When I look for the pet by id
    Then the status code is 404

  Scenario Outline: Update an existing pet by wrong form data
    And I change the "<Field>" for a pet
    When I update by "<Field>" form data the new pet
    Then the status code is <Status Code>

    Examples:
      | Field  | Status Code |
      | petId  | 404         |
      | name   | 400         |

  Scenario: Delete a non existing pet
    And I change the "petId" for a pet
    When I delete the new pet
    Then the status code is 400