package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//TC #1: Information alert practice
//1. Open browser
//2. Go to website: http://practice.cybertekschool.com/javascript_alerts
//3. Click to “Click for JS Alert” button
//4. Click to OK button from the alert
//5. Verify “You successfully clicked an alert” text is displayed.

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void p1_information_alert_practice() {
        //locating the warning/information alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //click to the button
        warningAlertButton.click();

        //1-Create Alert instance and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        //2-Use "alert" instance to accept the javascript alert (popup)
        alert.accept();

        //locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //assert "resultText" is displayed
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED!!!");
    }

    @Test
    public void p2_confirmation_alert_practice() {

        //locating the warning/information alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        //click to the button
        warningAlertButton.click();

        //Create alert instance
        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(2);

        //We can either accept(), or dismiss() the confirmation alert
        //alert.dismiss(); //to cancel
        alert.accept();

        //locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //assert "resultText" is displayed
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED!!!");
    }

    @Test
    public void p3_prompt_alert_practice(){
        /*
        TC #3: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        3. Click to “Click for JS Prompt” button
        4. Send “hello” text to alert
        5. Click to OK button from the alert
        6. Verify “You entered: hello” text is displayed.
         */
        WebElement JsPromptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JsPromptButton.click();
        BrowserUtils.wait(2);

        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.sendKeys("hello");
        BrowserUtils.wait(2);
        alert.accept();

        String resultMessage = driver.findElement(By.xpath("//p[.='You entered: hello']")).getText();
        String expectedMessage = "You entered: hello";


        Assert.assertEquals(resultMessage,expectedMessage,"Verification FAILED! Result message does not match");


       // driver.findElement(By.xpath("ok"));

    }
}
