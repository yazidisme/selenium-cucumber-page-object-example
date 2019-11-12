Test Automation using **Cucumber**, **JUnit**, **Maven**, and **Java Language** with **Page Object Model**
---
---

## How to Create?

#### 1. Java Development Kit (JDK)
* [Download](https://www.oracle.com/technetwork/java/javase/downloads/index.html) and [install](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-F575EB4A-70D3-4AB4-A20E-DBE95171AB5F) JDK
* Setting the system variables
    * Create and open your .bash_profile using Terminal
        ```sh
        $ cd ~/
        $ touch .bash_profile
        $ open -e .bash_profile
        ```
    * Set the Java paths in your .bash_profile file
        ```
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/JDK_VERSION_FOLDER/Contents/Home
        export PATH=$PATH:$JAVA_HOME/bin
        ```
    * Save and exit your .bash_profile
* Type `java -version` in your Terminal to verify installation and find out your java version
* See the output of [java version](https://prnt.sc/p8zd7s)

#### 2. Homebrew
* Install [Homebrew](https://brew.sh/) using Terminal and enter the following command
    ```sh
    $ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
    ```
* Follow the instructions until Homebrew installing success
* Type `brew --version` to find out your Homebrew version
* See the output of [homebrew version](https://prnt.sc/p8zgxb)

#### 3. ChromeDriver
* Install [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) using brew
* Type `brew cask install chromedriver` in your Terminal
* Follow the instructions until chromedriver installing success
* Type `chromedriver -version` to find out your chromedriver version
* See the output of [chromedriver version](https://prnt.sc/pv8v1r)

#### 4. Maven
* [Download](https://maven.apache.org/download.cgi) [Maven](https://maven.apache.org/) as your build tools
* Extract downloaded maven into your current or random directory
* Adding maven to the environment path
* Add path variable to .bash_profile file
    ```
    export M2_HOME=/your_directory/apache-maven-3.6.2
    export PATH=$PATH:$M2_HOME/bin
    ```
* Verify your maven installation using `mvn -version` in your Terminal
* See the output of [Maven version](https://prnt.sc/pvps0n)

#### 5. Intellij IDEA
* Download and install your IDE using [Intellij IDEA](https://www.jetbrains.com/idea/download/) or etc.
* Open your IDE that installed
* Create new project using Maven Project
    * Select File, New, Project...
    * [New Project](https://prnt.sc/pv92xe) window opened
    * Select Maven, Select Project SDK using dropdown list, Next
    * Fill the field in Group Id, Artifact Id, Version, then Next
    * Edit some field if needed, Finish
    * Default Maven Project should be like [this](https://prnt.sc/pvf5xr)
---

## How to Execute?

#### 1. Dependencies
* Add some dependencies that required for web test automation inside `pom.xml` file
* Some dependencies and plugins that initiate inside pom.xml file
    ```
    ...
    <properties>
            <cucumber.version>1.2.5</cucumber.version>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        </properties>
    
        <dependencies>
            <dependency>
                <groupId>info.cukes</groupId>
                <artifactId>cucumber-java</artifactId>
                <version>${cucumber.version}</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>info.cukes</groupId>
                <artifactId>cucumber-junit</artifactId>
                <version>${cucumber.version}</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>3.141.59</version>
            </dependency>
        </dependencies>
    
        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.7.0</version>
                </plugin>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.0</version>
                    <configuration>
                        <testFailureIgnore>true</testFailureIgnore>
                    </configuration>
                </plugin>
                <plugin>
                    <groupId>net.masterthought</groupId>
                    <artifactId>maven-cucumber-reporting</artifactId>
                    <version>3.8.0</version>
                    <executions>
                        <execution>
                            <id>execution</id>
                            <phase>verify</phase>
                            <goals>
                                <goal>generate</goal>
                            </goals>
                            <configuration>
                                <projectName>Cucumber Page Object Example</projectName>
                                <outputDirectory>target/cucumber-reports/advanced-reports</outputDirectory>
                                <cucumberOutput>target/cucumber-reports/CucumberTestReport.json</cucumberOutput>
                                <buildNumber>1</buildNumber>
                                <parallelTesting>false</parallelTesting>
                                <checkBuildResult>false</checkBuildResult>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    ```

#### 2. Test Runner
* Create java class file inside `src/test/java`
* Set the file name with **TestRunner**
* Then TestRunner.java should be like this
    ```
    import cucumber.api.CucumberOptions;
    import cucumber.api.junit.Cucumber;
    import org.junit.runner.RunWith;
    
    @RunWith(Cucumber.class)
    @CucumberOptions(
            glue = "StepDefinitions",
            format = {
                    "pretty",
                    "html:target/cucumber-reports/cucumber-pretty",
                    "json:target/cucumber-reports/CucumberTestReport.json"
            }
    )
    public class TestRunner { }
    ```

#### 3. Features
* Add **resources** folder inside `src/test`
* Then **features** folder inside `src/test/resources` 
* Create test cases scenario inside `src/test/resources/features`
* Write your scenario
    ```
    Feature: Credential Tests
    
      @ValidCase
      Scenario: Successful login
        Given Login page
        When Submit "YOUR_VALID@EMAIL.COM" and "YOUR_V4L1D_Password"
        Then Login success
    
      @InvalidCase
      Scenario Outline: Failed login
        Given Login page
        When Submit "<email>" and "<password>"
        Then Login failed
        Examples:
        | email             | password |
        | qwert             | 123456   |
        |                   | 1234qw   |
        | akutest@email.com |          |
    ```

#### 4. Page Objects
* Add **PageObjects** package inside `src/test/java`
* Create java class for initiate some page elements inside `src/test/java/PageObjects`
* Create HomePage.java for initiate home page elements
    ```
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
    ```
* Create LoginPage.java for initiate login page elements
    ```
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
    ```

#### 5. Step Definitions
* Add **StepDefinitions** package inside `src/test/java`
* Create java class for initiate some test steps inside `src/test/java/StepDefinitions`
* Create Setup.java for initiate global access 
    ```
    package StepDefinitions;
    
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    
    import java.util.concurrent.TimeUnit;
    
    public class Setup {
    
        WebDriver driver;
    
        public WebDriver goToUrl() {
    
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.bhinneka.com/");
            return driver;
        }
    }
    ```
* Create LoginSteps.java for initiate login steps
    ```
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
    ```

#### 6. Run the Test
* You are ready to automate the test in [Bhinneka.com](https://www.bhinneka.com/) login
* Run your test using `mvn clean verify` or `mvn verify` from Terminal

#### 7. Test Result
* See the result inside `target/cucumber-reports/advanced-reports/cucumber-html-reports` or `target/cucumber-reports/cucumber-pretty` folders that automatically generated after finished the test execution
* Open html file in your browser
* Or you can create your result view using json file inside  `target/cucumber-reports`
* Some sample of test results
    ![image1](https://github.com/yazidisme/image-attachment/blob/master/download1.png)
    ![image2](https://github.com/yazidisme/image-attachment/blob/master/download2.png)
    ![image3](https://github.com/yazidisme/image-attachment/blob/master/download3.png)
    ![image4](https://github.com/yazidisme/image-attachment/blob/master/download4.png)
    ![image5](https://github.com/yazidisme/image-attachment/blob/master/download5.png)
    ![image6](https://github.com/yazidisme/image-attachment/blob/master/download6.png)
    ![image7](https://github.com/yazidisme/image-attachment/blob/master/download7.png)
