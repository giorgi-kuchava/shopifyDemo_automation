package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By heading = By.xpath("//h1[normalize-space()='Customer Login']");
    private final By email = By.cssSelector("input[type='email'], input[name='customer[email]']");
    private final By password = By.cssSelector("input[type='password'], input[name='customer[password]']");
    private final By forgotPassword = By.xpath("//a[contains(normalize-space(), 'Forgot your password')]");
    private final By resetHeading = By.xpath("//h1[normalize-space()='Reset Password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        openPath("/account/login");
        return this;
    }

    public String headingText() {
        return textOf(heading);
    }

    public boolean hasLoginFields() {
        return isDisplayed(email) && isDisplayed(password);
    }

    public boolean hasResetPasswordSection() {
        click(forgotPassword);
        return isDisplayed(resetHeading);
    }

    public LoginPage enterCredentials(String emailAddress, String passwordValue) {
        type(email, emailAddress);
        type(password, passwordValue);
        return this;
    }
}
