package dto;

public record LoginResponse(
        long id,
        String username,
        String email
) {
}
