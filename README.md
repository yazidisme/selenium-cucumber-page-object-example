Test Automation using **Selenium**, **Cucumber**, **JUnit**, **Maven**, and **Java Language** with **Page Object Model**
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
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/{JDK_VERSION_FOLDER}/Contents/Home
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
    export HOME=/{YOUR_DIRECTORY}/apache-maven-{YOURVERSION}
    export PATH=$PATH:$HOME/bin
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

#### 1. Run the Test
* You are ready to automate the test in [Bhinneka.com](https://www.bhinneka.com/) login
* Run your test using `mvn install` or `mvn verify` from Terminal

#### 2. Test Result
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
