package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        //1- set up the web driver
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3- test if driver is working
        driver.get("https://www.google.com");


        System.out.println("the title of the page is: " +driver.getTitle());

        String actualTitle = driver.getTitle();

        System.out.println("Actual Title String: "+actualTitle);

        String actualURL = driver.getCurrentUrl();

        System.out.println("actualURL = " + actualURL);

        driver.navigate().back();


        driver.navigate().forward();


        driver.navigate().refresh();



        driver.navigate().to("https://www.facebook.com");
        
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

        driver.close();


    }
}
