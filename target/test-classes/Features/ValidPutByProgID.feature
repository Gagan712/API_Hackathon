Feature: To Upadte and validate a program by ProgramID With Negative Scenarios
 
 Scenario: To create a new Program for Put validation
    Given User get the Base Url to create program for Put validation
    When  User Put the data in map for Put validation
    Then  Request body with given data for Put validation
    When  Make a Post request for Progam by ProgramID for Put validation
    Then  validate the status code for Progam by ProgramID for Put validation
    Then  Save the programID for Progam by ProgramID for Put validation
    
    Scenario: To get Program by programID for Put validation
    When make a Get request by programId for Put validation
    Then Validate the get status code for Put validation
    
  Scenario: Update Program by ProgramID with invalid Put validation
    Given User get the Base URL for Put validation
    When Set Update Request with invalid Body for Put validation
    And Make a Put request for Put validation
    Then validate the put status code for Put validation

Scenario: Update Program by ProgramID for Put validation
    Given User get the Base URL for Put validation
    When Make a Put request with no Body for Put validation
    Then validate the put status code for Put validation

  Scenario: Delete Program by ProgramID for Put validation
    Given User get the Base Url for delete for Put validation
    When Make a Delete request for Put validation
    Then validate the delete status code for Put validation
    