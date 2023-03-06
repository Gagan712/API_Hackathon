Feature: Test Put Method in Programs API testing

  Scenario: Update Programs by ProgramName
    Given Set PUT program by programName endpoint
    When Set Update Request Body
    And Send HTTP request
    Then Validate response code
