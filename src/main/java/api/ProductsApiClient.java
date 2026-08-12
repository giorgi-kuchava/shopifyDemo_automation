package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import utils.ConfigReader;

public class ProductsApiClient {
    public Response getHomePage() {
        return getPath("/");
    }

    public Response getPath(String path) {
        return given()
                .baseUri(ConfigReader.get("api.base.url"))
                .when()
                .get(path);
    }
}
