package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends BasePage {
    private final By firstPost = By.xpath("//a[normalize-space()='First Post'] | //h2[contains(normalize-space(), 'First Post')]");
    private final By shopifyAuthor = By.xpath("//*[contains(normalize-space(), 'Posted by Shopify')]");

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public BlogPage open() {
        openPath("/blogs/news");
        return this;
    }

    public boolean hasFirstPost() {
        return isDisplayed(firstPost);
    }

    public boolean hasShopifyAuthor() {
        return isDisplayed(shopifyAuthor);
    }
}
