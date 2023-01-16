Feature: To validate Get Batches Request

  Scenario: To Get All Batches
    Given A service with URL for Batches
    When Set request header for Batches
    And Get request is made for Batches
    Then Validate status code for Batches
    And Validate batchId,batchName,batchDescription,batchStatus,batchNoOfClasses,programId,programName

  Scenario: To Get Batch by Id
    Given A GET service with URL for Batches
    When Get request header for Batches
    And Get request is made to get Batch by Id as 901
    Then Validate status code for Batch By Id
    Then Validate Batch Id as 901

  Scenario: To Get Batch by Name
    Given A GET service with URL for Batches by Name
    When Get request header for Batches by Name
    And Get request is made to get Batch by Name as "fake"
    Then Validate status code for Batch By Name
    Then Validate Batch Name as "fake"

  Scenario: To Get Batch by ProgramId
    Given A GET service with URL for Batches By ProgramId
    When Get request header for Batches ProgramId
    And Get request is made to get Batch by ProgramId as 305
    Then Validate status code for Batch By ProgramId
    Then Validate  ProgramId as 305
