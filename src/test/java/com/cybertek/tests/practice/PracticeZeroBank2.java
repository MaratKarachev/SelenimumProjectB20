package com.cybertek.tests.practice;


//TC #2: Zero Bank link text verification
// 1.Open Chrome browser
// 2.Go to http://zero.webappsecurity.com/login.html
// 3.Verify link text from top left:
// Expected: “Zero Bank”
// 4.Verify link href attribute value contains:
// Expected: “index.html”

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeZeroBank2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedTitle = "index.html";
        String actualTitle = driver.findElement(By.linkText("Zero Bank")).getAttribute("href");

        if(actualTitle.contains(expectedTitle)){
            System.out.println("PASS!");
        }else {
            System.out.println("FAILED!!!");
        }


    }
}
