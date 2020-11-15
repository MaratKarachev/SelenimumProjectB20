package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectingValueFromNonSelectDropdown {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }
    @Test
    public void nonSelectDropdown() throws InterruptedException {
        WebElement dropDownLink = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropDownLink.click();
        // Select facebook = new Select(driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")));
        WebElement facebook = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
        facebook.click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}