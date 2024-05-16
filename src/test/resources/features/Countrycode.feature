Feature: Country Code Validation

  Scenario Outline: Validate country code returns expected status code
    Given the REST endpoint "<endpoint>"
    When the request is made with country code "<countryCode>"
    Then the response status code should be <statusCode>
    And all soft assertions should pass

    Examples:
      | endpoint     | countryCode | statusCode |
      | /rest/List   | RU          | 403        |
      | /rest/Search | RU          | 403        |
      | /rest/Delete | RU          | 403        |
      | /rest/List   | INVALID     | 400        |
      # Add more examples for different endpoints and country codes