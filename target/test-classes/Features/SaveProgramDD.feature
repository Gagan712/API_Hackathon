Feature: To Create and validate a program using json File 
 
 Scenario: To create a new Program using json File
    Given User get the Base Url for Progam using json File
    When  User Request body with json file for Progam using json File
    Then  Make a Post request for Progam using json File
    When  validate the status code for Progam using json File
    Then  Save the programID for Progam using json File
    
  Scenario: To get Program by programID using json File
    Given User get the Base Url for Progam using json File
    When make a Get request by programId for Progam using json File
    Then Validate the get status code for Progam using json File
   
  Scenario: Delete Program by ProgramID using json File
    Given User get the Base Url for delete for Progam using json File 
    When Make a Delete request for Progam using json File
    Then validate the delete status code for Progam using json File
    