Feature: UserLoginController

Background:
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 200 created with auto generated token

  @tag1
  Scenario: Generate Token with valid credentials
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 200 created with auto generated token

  @tag2
  Scenario: Generate Token with invalid endpoint
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with invalid endpoint
    Then Admin receives 401 unauthorized

  @tag3
  Scenario: Generate token with invalid credentials
    Given Admin creates request with invalid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 401 Bad request

  @tag4
  Scenario: Check if Admin able to logout
    Given Admin creates request
    When Admin calls Get Https method with valid endpoint
    Then Admin receives 200 ok  and response with "Logout successful"

  @tag5
  Scenario: Check if Admin able to logout  with invalid endpoint
    Given Admin creates request
    When Admin calls Get Https method withinvalid endpoint
    Then Admin receives 404 Not found

  @tag6
  Scenario: Check if Admin able to logout
    Given Admin creates request
    When Admin calls Get Https method with valid endpoint with no auth
    Then Admin receives 401  unauthorizedd
    