Feature: Add order

  Scenario: SUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then The order is assigned a unique number.

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Write the client firstName >= than 41 characters.

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Write the client firstName than 0 characters.

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Save empty body - null.