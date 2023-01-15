Feature: To check the negative scenarios 

Scenario: Verify Get request throws error message on already deleted program Id

 Given I Set DELETE Program By Id endpoint
 When I Set a request header for Id
 And Send a DELETE By Id HTTP request
 Then I recive Valid GET status code for id
 When Send a GET By Id HTTP request
 But Program should not get fetched
 
 
 
 
    
    