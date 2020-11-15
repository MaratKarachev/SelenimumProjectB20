package com.cybertek.tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForVytrack {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // opens browser

        driver.get("https://qa2.vytrack.com/user/login"); // opens the login page for Vytrack application

        driver.findElement(By.id("prependedInput")).sendKeys("User163");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);
        driver.findElement(By.className("nav-multilevel main-menu")).sendKeys(Keys.ENTER);
        driver.findElement(By.className("title title-level-2")).sendKeys(Keys.ENTER);

        driver.close();
    }
}
