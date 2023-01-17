Feature: Validate the negative Scenarios of Post Request

  Scenario: Validate Post request with invalid Body
    Given Use Get the base Url
    When User set the request header
    Then User Put the invalid body data
    When User make the Post request with invalid body
    Then User validate the Status code

  Scenario: Validate Post request with No Body
    Given Use Get the base Url
    When User set the request header
    Then User Put the no body data
    When User make the Post request with no body
    Then User validate the Status code

  Scenario: Validate Post request with already Existing ProgramName
    Given Use Get the base Url
    When User set the request header
    Then User Put the body data with existing ProgramName
    When User make the Post request
    Then User validate the Status code
