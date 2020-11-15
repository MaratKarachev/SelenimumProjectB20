package com.cybertek.tests.day13_pom_synchronization;

import com.cybertek.pages.DynamicallyLoadedPageElements;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC41 {
//TC#41 : Dynamically Loaded Page Elements 1
//1. Go to http://practice.cybertekschool.com/dynamic_loading/1
//2. Click to start
//3. Wait until loading bar disappears
//4. Assert username inputbox is displayed
//5. Enter username: tomsmith
//6. Enter password: incorrectpassword
//7. Click to Submit button
//8. Assert “Your username is invalid!” text is displayed.
//Note: Follow POM

    @Test
    public void p41_dynamic_title_test2(){
        String url = ConfigurationReader.getProperty("DynamicallyLoadedPageElements");
        Driver.getDriver().get(url);

        DynamicallyLoadedPageElements dynamicallyLoadedPageElements = new DynamicallyLoadedPageElements();
        dynamicallyLoadedPageElements.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dynamicallyLoadedPageElements.usernameInputBox));

        Assert.assertTrue(dynamicallyLoadedPageElements.usernameInputBox.isDisplayed(),"Verification FAILED!");

        dynamicallyLoadedPageElements.usernameInputBox.sendKeys("DynamicallyLoadedPageElementsUserName");
        dynamicallyLoadedPageElements.passwordInputBox.sendKeys("DynamicallyLoadedPageElementsPassword");
        dynamicallyLoadedPageElements.submitButton.click();

        Assert.assertEquals(dynamicallyLoadedPageElements.errorMessage.getText(),("Your username is invalid!\n×"));
    }
}
