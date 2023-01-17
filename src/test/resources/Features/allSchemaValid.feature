Feature: Validation of Json Schema

  Scenario: To check valid json format for all Programs
    Given User get the Base URL for all Programs
    When User make the Get all Programs
    Then Get the Validate the Schema
