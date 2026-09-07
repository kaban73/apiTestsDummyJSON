package clients;

import dto.LoginRequest;
import io.restassured.response.Response;
import specs.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response authLogin(LoginRequest request) {
        return
            given()
                .spec(RequestSpecFactory.baseSpecs())
                .body(request)
            .when()
                    .post("auth/login");
    }

}
