package api.clients;

import api.dto.LoginRequest;
import api.specs.RequestSpecFactory;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(LoginRequest request) {
        return
            given()
                .spec(RequestSpecFactory.baseSpecs())
                .body(request)
            .when()
                    .post("/auth/login");
    }

    public Response auth(String accessToken) {
        return
                given()
                        .spec(RequestSpecFactory.authSpec(accessToken))
                .when()
                        .get("/auth/me");
    }

}
