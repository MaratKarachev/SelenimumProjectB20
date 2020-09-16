package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StoreManagerNotAbleToAccessVehicleOdometer {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager213");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(2000);
    }

    @Test
    public void StoreManagerNotAbleToSeeVehicleOdometer(){
        WebElement fleetManagementOption = driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        fleetManagementOption.click();

        driver.findElement(By.linkText("Vehicle Odometer")).click();


        String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message does not match");

        }
        }
