Feature: Get Order

  Scenario: SUCCESSFULLY GET BY ID
    Given User wants to get order
    Then The get by id 'IS SUCCESSFUL'

  Scenario: UNSUCCESSFULLY GET BY ID
    Given User wants to get order
    Then But it is not in the database. The get by id 'IS UNSUCCESSFUL'