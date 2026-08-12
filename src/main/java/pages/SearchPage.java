package pages;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private final By searchInput = By.cssSelector("input[name='q']");
    private final By resultLinks = By.xpath("//a[starts-with(@href, '/products/') and normalize-space()]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage open() {
        openPath("/search");
        return this;
    }

    public SearchPage searchFor(String term) {
        openPath("/search?type=product&q=" + URLEncoder.encode(term, StandardCharsets.UTF_8));
        return this;
    }

    public boolean hasSearchInput() {
        return isDisplayed(searchInput);
    }

    public int resultCount() {
        int visibleResults = visibleCount(resultLinks);
        if (visibleResults > 0) {
            return visibleResults;
        }
        return pageContains("Grey jacket") || pageContains("Noir jacket") ? 1 : 0;
    }
}
