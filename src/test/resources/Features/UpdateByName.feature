Feature: To Upadte and validate a program by name 
 
 Scenario: To create a new Program
    Given User get the Base Url for Progam by name
    When  User Put the data in map for Progam by name
    Then  Request body with given data for Progam by name
    When  Make a Post request for Progam by name
    Then  Save the programID for Progam by name
    Then  validate the status code for Progam by name
    
    Scenario: To get Program by programID
    When make a Get request by programId for Progam by name
    Then Validate the get status code for Progam by name
    Then Save the ProgramName for Progam by name
    
    
  Scenario: Update Programs by ProgramName
    Given User get the Base Url for Progam by name
    When Set Update Request Body for Progam by name
    And Make a Put request for Progam by name
    Then validate the put status code for Progam by name

  Scenario: Delete Programs by ProgramName
    Given User get the Base Url for delete for Progam by name 
    When Make a Delete request for Progam by name
    Then validate the delete status code for Progam by name
    