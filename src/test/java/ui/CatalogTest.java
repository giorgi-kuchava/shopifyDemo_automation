package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.ProductPage;
import pages.ProductsPage;

@Feature("Catalog")
public class CatalogTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that the catalog page shows products.")
    public void catalogShouldShowProducts() {
        ProductsPage productsPage = new ProductsPage(driver).open();

        assertEquals(productsPage.headingText(), "Products");
        assertTrue(productsPage.productCount() >= 7, "Catalog should show multiple products");
    }

    @Test(groups = "ui")
    @Description("Verifies that sold-out items are visible in the catalog.")
    public void catalogShouldShowSoldOutItems() {
        ProductsPage productsPage = new ProductsPage(driver).open();

        assertTrue(productsPage.hasSoldOutProduct(), "Catalog should show sold-out product status");
    }

    @Test(groups = "ui")
    @Description("Verifies that a catalog product opens its product detail page.")
    public void productCanBeOpenedFromCatalog() {
        ProductPage productPage = new ProductsPage(driver).open().openGreyJacket();

        assertEquals(productPage.productTitle(), "Grey jacket");
        assertTrue(productPage.hasPrice(), "Product price should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that the product detail page has description content.")
    public void productDetailShouldShowDescription() {
        ProductPage productPage = new ProductPage(driver).openGreyJacket();

        assertTrue(productPage.hasDescription(), "Product description should be visible");
    }
}
