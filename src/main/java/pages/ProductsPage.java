package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By heading = By.xpath("//h1[normalize-space()='Products']");
    private final By productLinks = By.xpath("//a[starts-with(@href, '/products/') and normalize-space()]");
    private final By greyJacketLink = By.xpath("//a[contains(@href, '/products/grey-jacket')]");
    private final By soldOutProduct = By.xpath("//*[contains(normalize-space(), 'Sold Out')]");
    private final String[] productNames = {
            "Black heels",
            "Bronze sandals",
            "Brown Shades",
            "Grey jacket",
            "Noir jacket",
            "Striped top",
            "White sandals"
    };

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        openPath("/collections/all");
        return this;
    }

    public String headingText() {
        return textOf(heading);
    }

    public int productCount() {
        visible(heading);
        int products = 0;
        for (String productName : productNames) {
            if (pageContains(productName)) {
                products++;
            }
        }
        return products;
    }

    public boolean hasSoldOutProduct() {
        return isDisplayed(soldOutProduct);
    }

    public ProductPage openGreyJacket() {
        clickFirstVisible(greyJacketLink);
        return new ProductPage(driver);
    }
}
