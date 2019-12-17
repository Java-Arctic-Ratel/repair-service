Feature: Add order

  Scenario: SUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then The order is assigned a unique number.

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Write the client first name "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Write the customer first name "".

  Scenario: Validation. UNSUCCESSFULLY adding a new order
    Given A new client brought a device.
    When Add a new client and device.
    Then Save empty body - null.