Feature: Single user API validation

  Scenario: Test case to validate SingleUser API service
    Given User is provided with SingleUser payload
    When User makes a API call with id as 2
    Then User receives the response response code as 200
    Then User validates the received response data
    Then User performs the JSON schema validation
    Then User validates the response time of the response