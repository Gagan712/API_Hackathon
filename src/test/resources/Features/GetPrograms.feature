Feature: To validate Programs module

Scenario: To Get All Programs
Given A service with URL
When Set request header
And Get request is made
Then Validate status code
And Validate ProgramId,ProgramName,ProgramDescription,ProgramStatus


Scenario: To Get Programs by Id
Given A GET service with URL
When Get request header
And Get request is made to get program by Id
Then Validate status code for Program By Id
And Validate ProgramName,ProgramDescription,ProgramStatus
