Feature: Validate the negative Scenarios of Post Request for Batch

  Scenario: To create a new Batch for Post validation
    Given User Get the base Url for Batch
    When User Put the data in map for Post validation
    Then Request body with given data for Post validation
    When Make a Post request for Post validation
    Then validate the status code for Post validation
    Then Save the batchID for Batch for Post validation
    Then Save the batchName for Batch for Post validation

  Scenario: Validate Post request with invalid Body
    Given User Get the base Url for Batch
    When User set the request header for Batch
    Then User Put the invalid body data for Batch
    When User make the Post request with invalid body for Batch
    Then User validate the Status code for Batch

  Scenario: Validate Post request with No Body
    Given User Get the base Url for Batch
    When User set the request header for Batch
    Then User Put the no body data for Batch
    When User make the Post request with no body for Batch
    Then User validate the Status code for Batch

  Scenario: Validate Post request with already Existing BatchName
    Given User Get the base Url for Batch
    When User set the request header for Batch
    Then User Put the body data with existing BatchName
    When User make the Post request with existing BatchName
    Then User validate the Status code for Batch

  Scenario: Delete Batch by BatchID for Post validation
    Given User Get the base Url for Batch
    When Make a Delete request for Post validation
    Then validate the delete status code for Post validation
