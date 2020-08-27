package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFacebook4 {

    //TC #4: Facebook header verification
    //1. Open Chrome browser
    //2. Go to https://www.facebook.com
    //3. Verify “Create a page” link href value contains text:
    //Expected: “registration_form”

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");


        String actualText = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        String expectedText = "registration_form";

        if(actualText.contains(expectedText)){
            System.out.println("PASS!");
        }else{
            System.out.println("FAILED!!!");
        }



    }
}
