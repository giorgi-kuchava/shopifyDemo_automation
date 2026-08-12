package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class HomePage extends BasePage {
    private final By tagline = By.xpath("//*[contains(normalize-space(), 'Just a demo site showing off what Sauce can do')]");
    private final By catalogLink = By.xpath("//a[@href='/collections/all' and normalize-space()='Catalog']");
    private final By blogLink = By.xpath("//a[@href='/blogs/news' and normalize-space()='Blog']");
    private final By aboutLink = By.xpath("//a[@href='/pages/about-us' and normalize-space()='About Us']");
    private final By loginLink = By.xpath("//a[@href='/account/login' and (normalize-space()='Login' or normalize-space()='Log In')]");
    private final By registerLink = By.xpath("//a[@href='/account/register' and (normalize-space()='Create account' or normalize-space()='Sign up')]");
    private final By featuredProducts = By.xpath("//a[starts-with(@href, '/products/') and normalize-space()]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(ConfigReader.get("base.url"));
        return this;
    }

    public boolean isLoaded() {
        return visible(tagline).isDisplayed();
    }

    public ProductsPage goToProducts() {
        click(catalogLink);
        return new ProductsPage(driver);
    }

    public BlogPage goToBlog() {
        click(blogLink);
        return new BlogPage(driver);
    }

    public AboutPage goToAbout() {
        click(aboutLink);
        return new AboutPage(driver);
    }

    public LoginPage goToLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }

    public RegisterPage goToRegister() {
        click(registerLink);
        return new RegisterPage(driver);
    }

    public CartPage goToCart() {
        openPath("/cart");
        return new CartPage(driver);
    }

    public int featuredProductCount() {
        return visibleCount(featuredProducts);
    }
}
