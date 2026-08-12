package ui;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.SearchPage;

@Feature("Search")
public class SearchTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that the search page loads with a search input.")
    public void searchPageShouldShowSearchInput() {
        assertTrue(new SearchPage(driver).open().hasSearchInput(), "Search input should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that searching for jacket returns product results.")
    public void searchShouldReturnMatchingProducts() {
        assertTrue(new SearchPage(driver).searchFor("Grey jacket").resultCount() > 0, "Search should return products");
    }
}
