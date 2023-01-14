Feature: Basic Login

@Acceptance
Scenario: The user is able to Login
    Given The user has a valid account
    When The user login into the page
    Then The user session is opened
    And A Status Code OK is displayed