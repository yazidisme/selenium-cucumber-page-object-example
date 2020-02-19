package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    @CacheLookup
    private WebElement emailField;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block bt-card__button']")
    @CacheLookup
    private WebElement signInButton;

    @FindBy(xpath = "//*[contains(@class,'has-error')]")
    @CacheLookup
    private WebElement errorMessageLabel;

    @FindBy(xpath = "//a[@href='/forgetpassword']")
    @CacheLookup
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[@href='/loginWithGoogle']")
    @CacheLookup
    private WebElement signInGoogleButton;

    @FindBy(xpath = "//a[@href='/loginWithFacebook']")
    @CacheLookup
    private WebElement signInFacebookButton;

    @FindBy(xpath = "//a[@href='/register']")
    @CacheLookup
    private WebElement registerLink;

    @FindBy(xpath = "//h1[text()='Sign In']")
    @CacheLookup
    private WebElement signInTitle;

    @FindBy(className = "navbar-brand")
    @CacheLookup
    private WebElement bhinnekaLogo;

    public void fillEmailData(String email) {

        WaitUntilElementVisible(emailField);
        emailField.isEnabled();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordData(String password) {

        WaitUntilElementVisible(passwordField);
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {

        WaitUntilElementVisible(signInButton);
        signInButton.isEnabled();
        signInButton.click();
    }

    public boolean errorMessageIsDisplayed() {

        WaitUntilElementVisible(errorMessageLabel);
        errorMessageLabel.isDisplayed();
        return true;
    }

    public boolean loginPageIsDisplayed() {

        WaitUntilElementVisible(bhinnekaLogo);
        bhinnekaLogo.isDisplayed();
        WaitUntilElementVisible(signInTitle);
        signInTitle.isDisplayed();
        WaitUntilElementVisible(emailField);
        emailField.isDisplayed();
        WaitUntilElementVisible(passwordField);
        passwordField.isDisplayed();
        WaitUntilElementVisible(signInButton);
        signInButton.isDisplayed();
        WaitUntilElementVisible(signInGoogleButton);
        signInGoogleButton.isDisplayed();
        WaitUntilElementVisible(signInFacebookButton);
        signInFacebookButton.isDisplayed();
        WaitUntilElementVisible(forgotPasswordLink);
        forgotPasswordLink.isDisplayed();
        WaitUntilElementVisible(registerLink);
        registerLink.isDisplayed();
        return true;
    }
}