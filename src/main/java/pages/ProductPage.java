package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private final By title = By.xpath("//h1[normalize-space()='Grey jacket']");
    private final By price = By.xpath("//*[contains(normalize-space(), '£55.00')]");
    private final By description = By.xpath("//*[contains(normalize-space(), 'product description')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage openGreyJacket() {
        openPath("/products/grey-jacket");
        return this;
    }

    public String productTitle() {
        return textOf(title);
    }

    public boolean hasPrice() {
        return isDisplayed(price);
    }

    public boolean hasDescription() {
        return isDisplayed(description);
    }
}
