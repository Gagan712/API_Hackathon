Feature: To Get the Size of Data

  Scenario: To calculate the items in Program Data
    Given User get the Base URL
    When User make the Get all data Request
    Then Get the size of Data

    Scenario: To calculate the items in Batch Data
    Given User get the Base URL for Batch
    When User make the Get all data Request for Batch
    Then Get the size of Data for Batch
    