package com.cybertek.tests.day13_pom_synchronization;


import com.cybertek.pages.VytrackLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//TC#30 : Vytrack negative login test à Wrong Password Test
//1. Go to https://qa3.vytrack.com
//2. Enter correct username
//3. Enter incorrect password
//4. Verify error message text is as expected Expected: “Invalid user name or password.”
//Note: Follow Page Object Model design pattern, and get your correct credentials
// from configuration.properties file

//TC#31 : Vytrack negative login test à Wrong Username Test
//1. Go to https://qa3.vytrack.com
//2. Enter incorrect username
//3. Enter correct password
//4. Verify error message text is as expected Expected: “Invalid user name or password.”
//Note: Follow Page Object Model design pattern, and get your correct
// credentials from configuration.properties file

//TC#32 : Vytrack positive login test à Sales Manager
// 1. Go to https://qa3.vytrack.com
//2. Enter correct username
//3. Enter correct password
//4. Verify title changed Expected: “Dashboard”
//Note: Follow Page Object Model design pattern, and get your correct
// credentials from configuration.properties file

//TC#33 : Vytrack positive login test à Driver Manager
//1. Go to https://qa3.vytrack.com
//2. Enter correct username
//3. Enter correct password
//4. Verify title changed Expected: “Dashboard”
//Note: Follow Page Object Model design pattern, and get
// your credentials from configuration.properties file

//TC#34 : Vytrack positive login test à Store Manager
//1. Go to https://qa3.vytrack.com
//2. Enter correct username
//3. Enter correct password
//4. Verify title changed Expected: “Dashboard”
//Note: Follow Page Object Model design pattern,
// and get your credentials from configuration.properties file

//TC#35 : Vytrack forgot password page verifications à TITLE and URL
//1. Go to https://qa3.vytrack.com
//2. Click to “Forgot your password?” link
//3. Verify title changed to expected
//Expected: “Forgot Password”
// 4. Verify url is as expected:
//Expected: “https://qa3.vytrack.com/user/reset-request”
// Note: Follow Page Object Model design pattern

//TC#36 : Vytrack forgot password page verification à ERROR MESSAGE
// 1. Go to https://qa3.vytrack.com/user/reset-request
//2. Enter random username
//3. Click to request button
//4. Verify error message is displayed
//5. Verify error message text is as expected.
//Expected: There is no active user with username or email address “given text”.
//Note: Follow Page Object Model design pattern

public class Practice30_31_32_33_34_35_36 {

    String forgotPasswordUrl = ConfigurationReader.getProperty("vytrackForgotPasswordUrl");
    VytrackLoginPage loginPage = new VytrackLoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @BeforeMethod
    public void setUpMethod(){
        String url = ConfigurationReader.getProperty("vytrackUrl");
        Driver.getDriver().get(url);

    }
    @Test
    public void VytrackNegativeLoginTestWrongPassword() {
        Driver.highlightElement(Driver.getDriver(),loginPage.userName);
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("vytrackHelpDeskUserName"));
        Driver.highlightElement(Driver.getDriver(),loginPage.password);
        loginPage.password.sendKeys(ConfigurationReader.getProperty("vytrackIncorrectPassword"));
        Driver.highlightElement(Driver.getDriver(),loginPage.loginButton);
        loginPage.loginButton.click();
        BrowserUtils.wait(2);
        Assert.assertTrue(loginPage.errorMessage.getText().equals("Invalid user name or password."), "Verification Failed!");

    }

    @Test
    public void VytrackNegativeLoginTestWrongUsername() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("vytrackIncorrectHelpDeskUserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("vytrackHelpDeskPassword"));
        loginPage.loginButton.click();
        BrowserUtils.wait(2);
        Assert.assertTrue(loginPage.errorMessage.getText().equals("Invalid user name or password."),"Verification Failed!");

    }

    @Test
    public void VytrackLoginTestSalesManager(){
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("vytrackSalesManagerUserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("vytrackPassword"));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"),"VERIFICATION FAILED!");
    }

    @Test
    public void VytrackLoginTestDriverManager(){
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("vytrackHelpDeskUserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("vytrackPassword"));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"),"VERIFICATION FAILED!");
    }
    @Test
    public void VytrackLoginTestStoreManager(){
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("vytrackStoreManagerUserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("vytrackPassword"));
        loginPage.loginButton.click();
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"),"VERIFICATION FAILED!");
    }
    @Test
    public void VytrackLoginForgotPassword(){
        loginPage.forgotPassword.click();
        wait.until(ExpectedConditions.titleIs("Forgot Password"));
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Forgot Password"),"Verification FAILED!");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("https://qa3.vytrack.com/user/reset-request"),"Verification FAILED");
    }
    @Test
    public void VytrackForgotPasswordErrorMessage(){
    Driver.getDriver().get(forgotPasswordUrl);
    Faker faker = new Faker();
    String randomUserName = faker.name().username();
    loginPage.userName.sendKeys(randomUserName);
    loginPage.requestButton.click();

    Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"FAILED!!!");
    Assert.assertEquals(loginPage.errorMessage.getText(),("There is no active user with username or email address \""+randomUserName+"\"."));

    }
   @AfterMethod
    public void tearDown() {
     // Driver.closeDriver();
    }
    }