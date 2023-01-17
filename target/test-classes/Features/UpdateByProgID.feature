Feature: To Upadte and validate a program by ProgramID
 
 Scenario: To create a new Program
    Given User get the Base Url for Progam by ProgramID
    When  User Put the data in map for Progam by ProgramID
    Then  Request body with given data for Progam by ProgramID
    When  Make a Post request for Progam by ProgramID
    Then  Save the programID for Progam by ProgramID
    Then  validate the status code for Progam by ProgramID
    
    Scenario: To get Program by programID
    When make a Get request by programId for Progam by ProgramID
    Then Validate the get status code for Progam by ProgramID
    
  Scenario: Update Program by ProgramID
    Given User get the Base Url for Progam by ProgramID
    When Set Update Request Body for Progam by ProgramID
    And Make a Put request for Progam by ProgramID
    Then validate the put status code for Progam by ProgramID

  Scenario: Delete Program by ProgramID
    Given User get the Base Url for delete for Progam by ProgramID
    When Make a Delete request for Progam by ProgramID
    Then validate the delete status code for Progam by ProgramID
    