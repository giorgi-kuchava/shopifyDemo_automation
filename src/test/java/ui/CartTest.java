package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.CartPage;

@Feature("Cart")
public class CartTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that an empty cart page displays the expected message.")
    public void cartShouldShowEmptyMessage() {
        CartPage cartPage = new CartPage(driver).open();

        assertEquals(cartPage.headingText(), "My Cart");
        assertTrue(cartPage.hasEmptyCartMessage(), "Empty cart message should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that Continue Shopping from the cart returns to the catalog.")
    public void continueShoppingShouldOpenCatalog() {
        CartPage cartPage = new CartPage(driver).open();

        assertEquals(cartPage.continueShopping().headingText(), "Products");
    }
}
