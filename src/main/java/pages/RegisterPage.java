package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private final By heading = By.xpath("//h1[normalize-space()='Create Account']");
    private final By firstName = By.cssSelector("input[name='customer[first_name]'], input[id*='FirstName']");
    private final By lastName = By.cssSelector("input[name='customer[last_name]'], input[id*='LastName']");
    private final By email = By.cssSelector("input[type='email'], input[name='customer[email]']");
    private final By password = By.cssSelector("input[type='password'], input[name='customer[password]']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage open() {
        openPath("/account/register");
        return this;
    }

    public String headingText() {
        return textOf(heading);
    }

    public boolean hasRegistrationFields() {
        return isDisplayed(firstName) && isDisplayed(lastName) && isDisplayed(email) && isDisplayed(password);
    }

    public RegisterPage enterRegistrationDetails(String first, String last, String emailAddress, String passwordValue) {
        type(firstName, first);
        type(lastName, last);
        type(email, emailAddress);
        type(password, passwordValue);
        return this;
    }
}
