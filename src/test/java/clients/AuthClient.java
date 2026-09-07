package clients;

import io.restassured.response.Response;
import specs.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response authLogin() {
        return
            given()
                .spec(RequestSpecFactory.baseSpecs())
            .when()
                    .post("auth/login");
    }

}
