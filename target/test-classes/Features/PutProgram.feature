Feature: To validate Put Request

  Scenario: Update Programs by ProgramID
    Given User get the Base Url for Put Program
    When User get all the data
    Then Set Update Request Body for Put Program
    When Make a Put request for Put Program
    Then validate the put status code for Put Program
