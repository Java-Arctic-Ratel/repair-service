Feature: Delete order

  Scenario: SUCCESSFULLY deleting order
    Given User wants to delete order.
    When Find the required order.
    Then The delete 'IS SUCCESSFUL'

  Scenario: UNSUCCESSFULLY deleting order
    Given User wants to delete order.
    When Find the required order.
    Then But it is not in the database. The delete 'IS UNSUCCESSFUL'