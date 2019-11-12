package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID_OR_NAME, using = "email")
    @CacheLookup
    public WebElement emailField;

    @FindBy(how = How.ID_OR_NAME, using = "password")
    @CacheLookup
    public WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-block bt-card__button']")
    @CacheLookup
    public WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//*[contains(@class,'has-error')]")
    @CacheLookup
    public WebElement messageError;
}
