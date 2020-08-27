package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFacebook1 {

    public static void main(String[] args) {


        // TC #1: Facebook title verification
        // 1.Open Chrome browser
        // 2.Go to https://www.facebook.com
        // 3.Verify title:
        // Expected: “Facebook -Log In or Sign Up”

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // opens browser

        driver.get("https://www.facebook.com"); // Go to https://www.facebook.com

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Verification Title PASSED!");
        }else{
            System.out.println("Verification Title FAILED!!!");
        }

        driver.close();


    }
}
