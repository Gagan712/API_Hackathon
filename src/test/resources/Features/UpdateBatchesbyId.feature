Feature: To Upadte and validate a Batch by BatchID

  Scenario: To create a new Batch
    Given User get the Base Url for Batch by BatchID
    When User Put the data in map for Batch by BatchID
    Then Request body with given data for Batch by BatchID
    When Make a Post request for Batch by BatchID
    Then Save the BatchId for Batch 
    Then validate the status code for Batch by BatchId

  Scenario: To get Batch by batchID
    When make a Get request by batchId for Batch by BatchID
    Then Validate the get status code for Batch by BatchID

  Scenario: Update Batch by BatchId
    Given User get the Base Url for Batch by BatchID
    When Set Update Request Body for Batch by batchId
    And Make a Put request for Batch by batchId
    Then validate the put status code for Batch by batchId

  Scenario: Delete Batch by batchId
    Given User get the Base Url for delete for Batch by batchId
    When Make a Delete request for Batch by batchId
    Then validate the delete status code for Batch by batchId
