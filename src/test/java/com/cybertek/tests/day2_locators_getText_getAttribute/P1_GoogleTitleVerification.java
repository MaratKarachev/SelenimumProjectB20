package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {

    public static void main(String[] args) {
        //TC #1: Google	Title	Verification
        // 1.Open	Chrome	browser
        //set up  the browser driver
        WebDriverManager.chromedriver().setup();


        //open a chrome browser
        //we create an instance of the ChromeDriver, which also opens an empty browser for us
        WebDriver driver  = new ChromeDriver(); // opens an empty browser

        // 2.Go	to	https://www.google.com
        driver.get("https://www.google.com");

        // 3.Verify	title:
        //Expected:	Google
        
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        
    }
}
