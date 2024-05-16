# Country Code Validation

This project demonstrates an end-to-end test case for validating the behavior of a REST API endpoint based on the provided country code. The test case ensures that the API returns the expected HTTP status code for different scenarios.

## Prerequisites

- Java Development Kit (JDK) 8 or above
- Apache Maven
- IntelliJ IDEA (or any other Java IDE)

## Project Setup

1. Clone the repository or import the project into your preferred IDE.

2. Make sure the necessary dependencies are resolved by running `mvn clean install` in the project root directory.

3. Update the `config.properties` file located in `src/test/resources/config` with the correct base URL and authentication token for your REST API endpoint.

## Running the Tests

1. Open the project in your IDE.

2. Locate the `RunCucumberTest` class in the `src/test/java/runners` package.

3. Right-click on the `RunCucumberTest` class and select "Run" or "Run 'RunCucumberTest'" from the context menu.

4. The Cucumber tests will be executed, and the test results will be displayed in the IDE's test runner.

5. You can also view the generated Cucumber report in the `target/cucumber-reports` directory.

## Test Scenario

The `Countrycode.feature` file located in `src/test/resources/features` contains a scenario outline that validates the behavior of the REST API endpoint based on the provided country code. The scenario outline includes examples to cover different endpoints, country codes, and expected status codes.

## Project Structure

- `src/main/java`: Contains the main application code (if applicable).
- `src/test/java`: Contains the test-related Java code.
- `src/test/resources`: Contains non-Java test-related files.

## Additional Notes

- The project uses Cucumber with Rest Assured for behavior-driven development (BDD) and API testing.
- The `RestTests` interface in the `utils` package encapsulates common REST testing functionalities.
- The `CountryCodeSteps` class in the `stepdefinitions` package contains the step definitions for the test scenario.

If you have any questions or need further assistance, please let me know.