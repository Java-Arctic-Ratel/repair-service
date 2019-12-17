Feature: Delete order

  Scenario: SUCCESSFULLY deleting order
    Given User wants to delete order.
    When Find the required order. Delete.
    Then The delete 'IS SUCCESSFUL'

  Scenario: UNSUCCESSFULLY deleting order
    Given User wants to delete order.
    When Find the required order. Delete.
    Then But ID = 1000 no in the database. The delete 'IS UNSUCCESSFUL'