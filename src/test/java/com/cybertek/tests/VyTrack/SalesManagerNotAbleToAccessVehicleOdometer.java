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

public class SalesManagerNotAbleToAccessVehicleOdometer {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("salesmanager263");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(2000);


    }

    @Test
    public void SalesManagerNotAbleToAccessVehicleOdometer() throws InterruptedException {
        WebElement fleetOption = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleetOption.click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard"; //Because page should deny the access to get in to Vehicle odometer page
        Assert.assertEquals(actualTitle, expectedTitle, "Sales manager has reached the Vehicle Odometer's page, VERIFICATION FAILED!!!");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
