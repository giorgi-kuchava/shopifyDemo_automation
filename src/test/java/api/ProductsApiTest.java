package api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;

@Feature("Products API")
public class ProductsApiTest {
    @Test(groups = "api")
    @Description("Verifies that the Shopify demo site responds successfully.")
    public void homePageShouldReturnSuccessfulResponse() {
        Response response = new ProductsApiClient().getHomePage();

        assertEquals(response.statusCode(), 200);
        assertTrue(response.asString().contains("Sauce Demo"), "Home page should contain the site name");
    }

    @Test(groups = "api")
    @Description("Verifies that public Shopify demo pages return successful responses.")
    public void publicPagesShouldReturnSuccessfulResponses() {
        ProductsApiClient client = new ProductsApiClient();
        String[] paths = {
                "/collections/all",
                "/products/grey-jacket",
                "/cart",
                "/account/login",
                "/account/register",
                "/blogs/news",
                "/pages/about-us",
                "/search?q=jacket"
        };

        for (String path : paths) {
            assertEquals(client.getPath(path).statusCode(), 200, path + " should return 200");
        }
    }
}
