package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginAndAuthResponse(
        long id,
        String username,
        String accessToken,
        String refreshToken
) {
}
