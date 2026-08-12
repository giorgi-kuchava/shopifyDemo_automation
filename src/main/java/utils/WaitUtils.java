package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitUtils {
    private WaitUtils() {
    }

    public static WebDriverWait explicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait")));
    }
}
