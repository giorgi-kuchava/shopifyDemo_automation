package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.AboutPage;
import pages.BlogPage;

@Feature("Content Pages")
public class ContentPagesTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that the About Us page loads with expected content.")
    public void aboutPageShouldLoad() {
        AboutPage aboutPage = new AboutPage(driver).open();

        assertEquals(aboutPage.headingText(), "About Us");
        assertTrue(aboutPage.hasDescription(), "About Us description should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that the blog page loads with the first post.")
    public void blogPageShouldShowFirstPost() {
        BlogPage blogPage = new BlogPage(driver).open();

        assertTrue(blogPage.hasFirstPost(), "Blog should show First Post");
        assertTrue(blogPage.hasShopifyAuthor(), "Blog should show the Shopify author line");
    }
}
