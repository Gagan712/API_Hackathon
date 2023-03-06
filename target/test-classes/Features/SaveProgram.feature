Feature: To Save and Validate A Program

  Scenario Outline: To create two new program
    Given User get the Base Url
    When User Put the "<programName>","<programDescription>","<programStatus>",creation time,lastModtime in Json
    Then Request body with given data
    When Make a Post request
    And Save the programID
    Then validate the status code
    Then validate "<programName>","<programDescription>","<programStatus>"
    When make a Get request by programId
    And Validate the get status code
    Then validate "<programName>","<programDescription>","<programStatus>"

    Examples: 
      | programName                | programDescription  | programStatus |
      | Jan23-API Coders-SDET-0999 | Learn RestAssure    | Active        |
      | Jan23-API Coders-SDET-0998 | Learn RestAssureAPI | Active        |
