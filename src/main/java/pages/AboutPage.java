package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {
    private final By heading = By.xpath("//h1[normalize-space()='About Us']");
    private final By description = By.xpath("//*[contains(normalize-space(), 'This is a demo site created for Sauce')]");

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public AboutPage open() {
        openPath("/pages/about-us");
        return this;
    }

    public String headingText() {
        return textOf(heading);
    }

    public boolean hasDescription() {
        return isDisplayed(description);
    }
}
