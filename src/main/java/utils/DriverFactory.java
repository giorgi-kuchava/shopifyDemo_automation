package utils;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(createDriver());
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }

    private static WebDriver createDriver() {
        String browser = ConfigReader.get("browser").toLowerCase(Locale.ROOT);
        WebDriver driver;

        switch (browser) {
            case "brave":
                System.setProperty("webdriver.chrome.driver",
                        "/Users/giorgikuchava/.cache/selenium/chromedriver/mac-arm64/151.0.7922.77/chromedriver");
                driver = new ChromeDriver(braveOptions());
                break;
            case "chrome":
                driver = new ChromeDriver(new ChromeOptions());
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait")));
        driver.manage().window().maximize();
        return driver;
    }

    private static ChromeOptions braveOptions() {
        ChromeOptions options = new ChromeOptions();
        String binary = System.getProperty("brave.binary", defaultBraveBinary());
        if (binary != null && !binary.isBlank()) {
            options.setBinary(binary);
        }
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-popup-blocking");

        // unique dir per JVM thread + run, avoids profile lock collisions
        String uniqueProfile = System.getProperty("java.io.tmpdir")
                + "/brave-selenium-profile-"
                + Thread.currentThread().getId() + "-"
                + System.currentTimeMillis();
        options.addArguments("--user-data-dir=" + uniqueProfile);
        return options;
    }

    private static String defaultBraveBinary() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("mac")) {
            return "/Applications/Brave Browser.app/Contents/MacOS/Brave Browser";
        }
        if (os.contains("win")) {
            return "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
        }
        return "/usr/bin/brave-browser";
    }
}
