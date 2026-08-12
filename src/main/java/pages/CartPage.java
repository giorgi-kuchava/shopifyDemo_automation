package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By heading = By.xpath("//h1[normalize-space()='My Cart']");
    private final By emptyMessage = By.xpath("//*[contains(normalize-space(), 'cart is currently empty')]");
    private final By continueShoppingLink = By.cssSelector("a[href='/collections/all']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        openPath("/cart");
        return this;
    }

    public String headingText() {
        return textOf(heading);
    }

    public boolean hasEmptyCartMessage() {
        return isDisplayed(emptyMessage);
    }

    public ProductsPage continueShopping() {
        click(continueShoppingLink);
        return new ProductsPage(driver);
    }
}
