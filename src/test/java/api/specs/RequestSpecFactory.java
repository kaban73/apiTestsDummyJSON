package api.specs;

import core.config.Config;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecFactory {

    private RequestSpecFactory() {

    }

    public static RequestSpecification baseSpecs() {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(Config.baseUrl());
    }

    public static RequestSpecification authSpec(String token) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(Config.baseUrl())
                .header("Authorization", "Bearer " + token);
    }
}
