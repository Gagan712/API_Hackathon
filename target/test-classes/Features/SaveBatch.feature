Feature: To Create and Validate A Batch

  Scenario Outline: To create two new Batches
    Given User get the Base Url for Batch
    When User Put the "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>","<programName>"
    Then Request body with given data for Batch
    When Make a Post request for Batch
    And Save the batchID for Batch
    Then validate the status code for Batch
    Then validate "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>","<programName>"
    When make a Get request by batchID for Batch
    And Validate the get status code for Batch
    Then validate "<batchName>","<batchDescription>","<batchStatus>","<batchNoOfClasses>","<programId>","<programName>"

    Examples: 
      | batchName                        | batchDescription  | batchStatus | batchNoOfClasses | programId | programName |
      | Jan23-API Coders-SDET-SDET85-099 | Learn PostMan     | Active      |                5 |        634| PostMan     |
      | Jan23-API Coders-SDET-SDET85-098 | Learn API Testing | Active      |                7 |        543 | API Testing |
