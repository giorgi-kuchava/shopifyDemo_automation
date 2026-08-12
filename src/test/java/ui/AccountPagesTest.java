package ui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pages.LoginPage;
import pages.RegisterPage;

@Feature("Account Pages")
public class AccountPagesTest extends BaseUiTest {
    @Test(groups = "ui")
    @Description("Verifies that the login page loads with email and password fields.")
    public void loginPageShouldShowLoginForm() {
        LoginPage loginPage = new LoginPage(driver).open();

        assertEquals(loginPage.headingText(), "Customer Login");
        assertTrue(loginPage.hasLoginFields(), "Login form fields should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that the reset password section is available on the login page.")
    public void loginPageShouldShowResetPasswordSection() {
        LoginPage loginPage = new LoginPage(driver).open();

        assertTrue(loginPage.hasResetPasswordSection(), "Reset password section should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that the create account page loads with registration fields.")
    public void registerPageShouldShowRegistrationForm() {
        RegisterPage registerPage = new RegisterPage(driver).open();

        assertEquals(registerPage.headingText(), "Create Account");
        assertTrue(registerPage.hasRegistrationFields(), "Registration form fields should be visible");
    }

    @Test(groups = "ui")
    @Description("Verifies that account form fields accept typed values.")
    public void accountFormsShouldAcceptInput() {
        new LoginPage(driver)
                .open()
                .enterCredentials("demo@example.com", "Password123");

        new RegisterPage(driver)
                .open()
                .enterRegistrationDetails("Demo", "User", "demo.user@example.com", "Password123");
    }
}
