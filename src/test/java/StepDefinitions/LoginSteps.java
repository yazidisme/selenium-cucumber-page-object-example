package StepDefinitions;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;

    @Before
    public void openBrowser() {

        Setup openBrowser = new Setup();
        driver = openBrowser.goToUrl();
    }

    @After
    public void quitBrowser() {

        driver.quit();
    }

    @Given("Login page")
    public void loginPage() {

        HomePage home = new HomePage(driver);
        home.masukButton.isDisplayed();
        home.daftarButton.isDisplayed();
        home.masukButton.isEnabled();
        home.masukButton.click();
    }

    @When("Submit \"(.*)\" and \"(.*)\"$")
    public void submitEmailPassword(String email, String password) {

        LoginPage login = new LoginPage(driver);
        login.emailField.isDisplayed();
        login.passwordField.isDisplayed();
        login.emailField.sendKeys(email);
        login.passwordField.sendKeys(password);
        login.signInButton.isEnabled();
        login.signInButton.click();
    }

    @Then("Login success")
    public void loginSuccess() {

        HomePage home = new HomePage(driver);
        Assert.assertEquals(home.haloHeader.isDisplayed(), true);
    }

    @Then("Login failed")
    public void loginFailed() {

        LoginPage login = new LoginPage(driver);
        Assert.assertEquals(login.messageError.isDisplayed(), true);
    }
}
