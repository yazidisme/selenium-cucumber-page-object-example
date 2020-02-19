package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    private final String headerMainMenu = "//div[@class='row main-menu-merchant']";
    private final String cartMenu = "//div[@class='navbar-cart']//a[@href='/cart']";

    @FindBy(xpath = headerMainMenu + "//div[@class='navbar-header']//a[@class='navbar-logo']")
    @CacheLookup
    private WebElement logoButton;

    @FindBy(xpath = headerMainMenu + "//input[@type='search']")
    @CacheLookup
    private WebElement searchInput;

    @FindBy(xpath = headerMainMenu + "//div[@class='navbar-login']//a[@href='/login']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath = headerMainMenu + cartMenu)
    @CacheLookup
    private WebElement cartButton;

    @FindBy(className = "bt-chat__button")
    @CacheLookup
    private WebElement openChatButton;

    @FindBy(xpath = headerMainMenu + "//a[@class='dropdown-toggle']")
    @CacheLookup
    private WebElement accountButton;

    @FindBy(xpath = cartMenu + "//span[@class='bt-navbar__badge']")
    @CacheLookup
    private WebElement cartWithBadge;

    public boolean homePageIsDisplayed() {

        WaitUntilElementVisible(logoButton);
        logoButton.isDisplayed();
        WaitUntilElementVisible(searchInput);
        searchInput.isDisplayed();
        WaitUntilElementVisible(loginButton);
        loginButton.isDisplayed();
        WaitUntilElementVisible(cartButton);
        cartButton.isDisplayed();
        WaitUntilElementVisible(openChatButton);
        openChatButton.isDisplayed();
        return true;
    }

    public void clickLoginButton() {

        WaitUntilElementVisible(loginButton);
        loginButton.isEnabled();
        loginButton.click();
    }

    public boolean homePageAfterLoginIsDisplayed() {

        WaitUntilElementVisible(accountButton);
        accountButton.isDisplayed();
        WaitUntilElementVisible(cartWithBadge);
        cartWithBadge.isDisplayed();
        return true;
    }
}