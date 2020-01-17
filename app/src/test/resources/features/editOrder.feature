Feature: Edit order

  Scenario: SUCCESSFULLY order edit
    Given Order is ready to issue.
    When Find the order.
    Then Change status --> "Ready".

  Scenario: Validation. UNSUCCESSFULLY order edit
    Given User need to edit the client first name in a order.
    When Find the order.
    Then Write the client lastName >= than 41 characters.

  Scenario: Validation. UNSUCCESSFULLY order edit
    Given User need to edit the client first name in a order.
    When Find the order.
    Then Write the client lastName than 0 characters.