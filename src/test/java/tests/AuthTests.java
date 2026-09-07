package tests;

import clients.AuthClient;
import dto.LoginRequest;
import dto.LoginResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AuthTests {

    @Test
    public void authLoginTest() {
        LoginRequest request = new LoginRequest(
                "emilys",
                "emilyspass"
        );
        AuthClient authClient = new AuthClient();

        Response response = authClient.login(request);

        response.then().statusCode(200);

        LoginResponse loginResponse = response.as(LoginResponse.class);

        assertTrue(loginResponse.id() > 0);
        assertEquals(loginResponse.username(), request.username());
        assertNotNull(loginResponse.accessToken());
        assertFalse(loginResponse.accessToken().isBlank());
        assertNotNull(loginResponse.refreshToken());
        assertFalse(loginResponse.refreshToken().isBlank());
    }

}
