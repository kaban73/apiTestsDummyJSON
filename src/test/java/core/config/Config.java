package core.config;

public final class Config {

    private Config() {
    }
    public static String baseUrl() {
        return ConfigReader.get("base.url");
    }
}
