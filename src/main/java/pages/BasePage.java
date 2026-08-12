package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.WaitUtils;

public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement visible(By locator) {
        return WaitUtils.explicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean isDisplayed(By locator) {
        return visible(locator).isDisplayed();
    }

    protected void click(By locator) {
        WaitUtils.explicitWait(driver).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void clickFirstVisible(By locator) {
        WebElement element = driver.findElements(locator)
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseGet(() -> visible(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        WaitUtils.explicitWait(driver).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(By locator, String value) {
        WebElement element = visible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected String textOf(By locator) {
        return visible(locator).getText();
    }

    protected int count(By locator) {
        return driver.findElements(locator).size();
    }

    protected int visibleCount(By locator) {
        return (int) driver.findElements(locator)
                .stream()
                .filter(WebElement::isDisplayed)
                .count();
    }

    protected boolean pageContains(String text) {
        return driver.getPageSource().toLowerCase().contains(text.toLowerCase());
    }

    protected void openPath(String path) {
        driver.get(utils.ConfigReader.get("base.url") + path);
    }

    public String title() {
        return driver.getTitle();
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
