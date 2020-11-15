package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTestForOdometers {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void truckDriverLogin() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("user163");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title test FAIL!");

        WebElement fleetOption = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleetOption.click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(2000);

        String expectedTitleVehicleOdometer = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualTitleVehicleOdometer = driver.getTitle();
        Assert.assertEquals(actualTitleVehicleOdometer,expectedTitleVehicleOdometer,"Vehicle Odometer page TITLES are NOT matching");
    }

    @Test
    public void storeManagerLogin() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager213");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title test FAIL!");

        WebElement fleetOption = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleetOption.click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(2000);

        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText();
        // System.out.println(actualMessage);
        String expectedMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match");

    }

    @Test
    public void salesManagerLogin() throws InterruptedException {
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager263");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(1000);
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title test FAIL!");

        WebElement fleetOption = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleetOption.click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(2000);

        String actualTitleVehicleOdometer = driver.getTitle();
        String expectedTitleVehicleOdometer = "Dashboard"; //Because page should deny the access to get in to Vehicle odometer page
        Assert.assertEquals(actualTitleVehicleOdometer, expectedTitleVehicleOdometer, "Sales manager has reached the Vehicle Odometer's page, VERIFICATION FAILED!!!");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
