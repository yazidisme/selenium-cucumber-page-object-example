package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='bt-navbar__account bt-navbar__user dropdown']//a[contains(text(),'Masuk')]")
    @CacheLookup
    public WebElement masukButton;

    @FindBy(how = How.XPATH, using = "//div[@class='bt-navbar__account bt-navbar__user dropdown']//a[contains(text(),'Daftar')]")
    @CacheLookup
    public WebElement daftarButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Halo,']")
    @CacheLookup
    public WebElement haloHeader;
}
