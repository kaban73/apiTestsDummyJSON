package tests;

import clients.AuthClient;
import dto.LoginRequest;
import dto.LoginAndAuthResponse;
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

        LoginAndAuthResponse loginResponse = response.as(LoginAndAuthResponse.class);

        assertTrue(loginResponse.id() > 0);
        assertEquals(loginResponse.username(), request.username());
        assertNotNull(loginResponse.accessToken());
        assertFalse(loginResponse.accessToken().isBlank());
        assertNotNull(loginResponse.refreshToken());
        assertFalse(loginResponse.refreshToken().isBlank());
    }

    @Test
    public void authMeTest() {
        LoginRequest request = new LoginRequest(
                "emilys",
                "emilyspass"
        );
        AuthClient authClient = new AuthClient();

        Response response = authClient.login(request);

        response.then().statusCode(200);

        LoginAndAuthResponse loginResponse = response.as(LoginAndAuthResponse.class);

        String accessToken = loginResponse.accessToken();
        Response authResponse = authClient.auth(accessToken);

        authResponse.then().statusCode(200);

        LoginAndAuthResponse authResponseDto = authResponse.as(LoginAndAuthResponse.class);

        assertEquals(authResponseDto.username(), loginResponse.username());
    }

}
