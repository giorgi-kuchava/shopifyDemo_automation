package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.HomePage;

@Feature("Home Page")
public class HomePageTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that the Shopify demo home page opens and Catalog navigation works.")
    public void homePageShouldOpenAndNavigateToProducts() {
        HomePage homePage = new HomePage(driver).open();

        assertTrue(homePage.isLoaded(), "Home page logo should be visible");
        assertEquals(homePage.goToProducts().headingText(), "Products");
    }
}
