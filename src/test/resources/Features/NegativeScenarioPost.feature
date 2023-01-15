Feature: Negative scenario POST request

  Scenario Outline: Program should not be created without all fields in body
    Given User get the Base Url as "URL"
    When User Put the "<programName>","<programDescription>",creation time,lastModtime in Json
    Then Request body with given data
    When Make a Post request
 	But Program should not be created

    Examples: 
      | programName                | programDescription  | 
      | Jan23-API Coders-SDET-017-9  | Learn RestAssure API   |
      
    Scenario Outline: Program should not be created with empty values in body
    Given User get the Base Url as "URL"
    When User Put the "<programName>","<programDescription>",creation time,lastModtime in Json
    Then Request body with given data
    When Make a Post request
 	But Program should not be created

    Examples: 
    | programName                | programDescription  | programStatus |
     | Jan23-API Coders-SDET-017-6 |     				| Active        |
     | Jan23-API Coders-SDET-017-8 | Learn  RestAssureAPI |        		|
     