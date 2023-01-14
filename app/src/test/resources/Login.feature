Feature: Basic Login

@Acceptance
Scenario: The user is able to login into the page
    Given The user has a valid account
    When The user login into the page
    Then The user session is opened
    And A Status Code OK is displayed

@Negative
Scenario Outline: The user is not able to login into the page
    Given The user does not have a valid account
    When The user enters <username> and <password>
    Then The user session is not opened
    And A Status Code Bad Request is displayed
    Examples:
        | username | password |
        | "rodrigoo" | "apitest"  |
        | "rodrigo.bernal" | "apitest" |
        | "rodrigo" | "apitesting" |
        | "rodrigo.   " | "API" |
        | "rodrigo.bernal" | "Apitesting" |