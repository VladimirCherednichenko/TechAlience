package utils;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public interface RestTests {
    Logger logger = LogManager.getLogger(RestTests.class);
    Properties config = loadConfig();
    SoftAssertions softAssertions = new SoftAssertions();

    static Properties loadConfig() {
        Properties config = new Properties();
        try (InputStream input = RestTests.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            config.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return config;
    }

    default Response sendGetRequest(String endpoint, String countryCode) {
        String url = config.getProperty("base.url") + endpoint +
                "?countryCode=" + countryCode +
                "&languageCode=en&searchText=example";
        logger.info("Sending GET request to: " + url);
        return given()
                .header("Authorization", "Bearer " + config.getProperty("auth.token"))
                .when()
                .get(url);
    }

    default int getResponseStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        logger.info("Response status code: " + statusCode);
        return statusCode;
    }

    default void validateStatusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = getResponseStatusCode(response);
        softAssertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

    default void assertAll() {
        softAssertions.assertAll();
    }
}