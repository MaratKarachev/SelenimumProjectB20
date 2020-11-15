package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateVehicleOdometer {
    public static void main(String[] args) throws InterruptedException {
        // Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        // VyTrack application URL "https://qa2.vytrack.com/user/login"
        driver.get("https://qa2.vytrack.com/user/login");
        //Enter username "user165" as a truck driver
        driver.findElement(By.id("prependedInput")).sendKeys("user163");
        // Password "UserUser123"
        // Click the "Login button"
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        // should click the "Fleet" button
        WebElement fleetButton = driver.findElement(By.linkText("Fleet"));
        fleetButton.click();
        // Click the "Vehicle odometer" button
        WebElement vehicleOdometerModule = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        vehicleOdometerModule.click();
        Thread.sleep(3000);
        WebElement createButton = driver.findElement(By.linkText("Create Vehicle Odometer"));
        createButton.click();
        // createButton.click();
        Thread.sleep(2000);
        WebElement OdometerValue = driver.findElement(By.xpath("//input[@name='custom_entity_type[OdometerValue]']"));
        OdometerValue.sendKeys("100000"+Keys.ENTER);


    }
}