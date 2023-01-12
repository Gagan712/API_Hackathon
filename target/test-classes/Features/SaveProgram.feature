Feature: To Save and Validate A Program

  Scenario Outline: To create two new program
    Given User get the Base Url as "URL"
    When User Put the "<programName>","<programDescription>","<programStatus>","<creationTime>","<lastModTime>" in Json
    Then Request body with given data
    When Make a Post request
    Then validate the status code

    Examples: 
      | programName               | programDescription  | programStatus | creationTime                  | lastModTime                   |
      | Jan23-API Coders-SDET-771 | Learn RestAssure    | Active        | 2023-01-07T04:13:00.000+00:00 | 2023-01-07T04:13:00.000+00:00 |
      | Jan23-API Coders-SDET-772 | Learn RestAssureAPI | Active        | 2023-01-07T04:13:00.000+00:00 | 2023-01-07T04:13:00.000+00:00 |
