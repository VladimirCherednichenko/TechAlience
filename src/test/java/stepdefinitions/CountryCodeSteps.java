package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.RestTests;

public class CountryCodeSteps implements RestTests {
    private String endpoint;
    private Response response;

    @Given("the REST endpoint {string}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("the request is made with country code {string}")
    public void makeRequest(String countryCode) {
        response = sendGetRequest(endpoint, countryCode);
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int expectedStatusCode) {
        validateStatusCode(response, expectedStatusCode);
    }

    @Then("all soft assertions should pass")
    public void assertAllSoftAssertions() {
        assertAll();
    }
}