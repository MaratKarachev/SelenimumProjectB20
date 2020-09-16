package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
TASK: NEW METHOD CREATION
Method name: getDriver
Static method
Accepts string argument: browserType --> will determine what browser opens
return type: WebDriver

//BREAK UNTIL: 12.11PM
 */
    public class WebDriverFactory {


        public static WebDriver getDriver(String browserType) {
            if (browserType.equalsIgnoreCase("Chrome")) {
                //System.setProperty("webDriver.chrome.driver","path");

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            }else if(browserType.equalsIgnoreCase("FireFox")){
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            }else {
                System.out.println("Given browser does not exist. Driver = null!");
                return null;
            }
        }
    }


