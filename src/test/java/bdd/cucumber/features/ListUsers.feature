Feature: To validate ListUsers API

  Scenario: Test case to validate ListUsers API successful response
    Given User has the ListUsersAPI payload
    When User makes a GET call
    Then User receives the response with 200 as response code
    Then User validates the response data
    Then User validates the JSON schema
    Then User validates the response time