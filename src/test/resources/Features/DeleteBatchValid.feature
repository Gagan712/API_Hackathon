Feature: To check the negative scenarios for Delete Request for Batch

  Scenario: To create a new batch For Delete Validation
    Given User get the Base Url For Delete Batch Validation
    When User Put the data in map For Delete Batch Validation
    Then Request body with given data For Delete Batch Validation
    When Make a Post request For Delete Batch Validation
    Then Save the batchID For Delete  Batch Validation
    Then validate the status code For Delete Batch Validation

  Scenario: Verify Get request throws error message on already deleted program Id
    Given User Get Base Url for DELETE Batch By Id
    When User Set a request header for Delete Batch Request
    And User Send a DELETE Request By Batch Id
    Then User receive Valid GET status code for Delete Batch
    When User Send a GET Request By BatchID
    But Program should not get fetched By BatchID
