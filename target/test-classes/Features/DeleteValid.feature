Feature: To check the negative scenarios for Delete Request

Scenario: To create a new Program For Delete Validation
    Given User get the Base Url For Delete Validation
    When  User Put the data in map For Delete Validation
    Then  Request body with given data For Delete Validation
    When  Make a Post request For Delete Validation
    Then  Save the programID For Delete Validation
    Then  validate the status code For Delete Validation

Scenario: Verify Get request throws error message on already deleted program Id

 Given User Get Base Url for DELETE Program By Id 
 When  User Set a request header for Delete Request
 And  User Send a DELETE Request By Program Id
 Then User receive Valid GET status code
 When User Send a GET Request By ProgramId 
 But  Program should not get fetched