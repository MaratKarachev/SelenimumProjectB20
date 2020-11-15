package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPageClass {
    WebDriver driver;

    public void login(String userName, String password) {
        driver = WebDriverFactory.getDriver("chrome");
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);


    }
}
