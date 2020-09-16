package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class SmokeTestProjectLogin {
        WebDriver driver;
        @BeforeMethod
        public void setUpMethod(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qa2.vytrack.com/user/login");
        }
        @Test
        public void truckDriverLogin() throws InterruptedException {
            driver.findElement(By.id("prependedInput")).sendKeys("user163");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
            Thread.sleep(1000);
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle,"Title test FAIL!");
        }
        @Test
        public void storeManagerLogin() throws InterruptedException {
            driver.findElement(By.id("prependedInput")).sendKeys("storemanager213");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
            Thread.sleep(1000);
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle,"Title test FAIL!");
        }
        @Test
        public void salesManagerLogin() throws InterruptedException {
            driver.findElement(By.id("prependedInput")).sendKeys("salesmanager263");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
            Thread.sleep(1000);
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle,"Title test FAIL!");

        }
        @AfterMethod
        public void tearDownMethod() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }
    }

