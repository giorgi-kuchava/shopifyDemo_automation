package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.HomePage;

@Feature("Navigation")
public class NavigationTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies navigation from Home to Catalog.")
    public void homeShouldNavigateToCatalog() {
        assertEquals(new HomePage(driver).open().goToProducts().headingText(), "Products");
    }

    @Test(groups = "ui")
    @Description("Verifies navigation from Home to Blog.")
    public void homeShouldNavigateToBlog() {
        assertTrue(new HomePage(driver).open().goToBlog().hasFirstPost(), "Blog page should open");
    }

    @Test(groups = "ui")
    @Description("Verifies navigation from Home to About Us.")
    public void homeShouldNavigateToAboutUs() {
        assertEquals(new HomePage(driver).open().goToAbout().headingText(), "About Us");
    }

    @Test(groups = "ui")
    @Description("Verifies navigation from Home to Login.")
    public void homeShouldNavigateToLogin() {
        assertEquals(new HomePage(driver).open().goToLogin().headingText(), "Customer Login");
    }

    @Test(groups = "ui")
    @Description("Verifies navigation from Home to Create Account.")
    public void homeShouldNavigateToCreateAccount() {
        assertEquals(new HomePage(driver).open().goToRegister().headingText(), "Create Account");
    }

    @Test(groups = "ui")
    @Description("Verifies navigation from Home to Cart.")
    public void homeShouldNavigateToCart() {
        assertEquals(new HomePage(driver).open().goToCart().headingText(), "My Cart");
    }
}
