package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    //Mini-TC41:
    //#1- Create a new class called : SmartBearUtilities
    //#2- Create a static method called loginToSmartBear
    //#3- This method simply logs in to SmartBear when you call it.
    //#4- Accepts WebDriver type as parameter
    public static void loginToSmartBear(WebDriver driver) {
        //3. Enter username: “Tester”

        WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordInput.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();


    }

    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("delayed something");
        }
    }

    /*
        My version:
        public static void verifyOrder(WebDriver driver, String name){
            String allNames = driver.findElement(By.xpath("//td[.='"+name+"']")).getText();
            String expectedName = name;
       }
     */
    //Created a locator that only returns the names of the costumer from all the rows
    //Created a list and stored the cells that has costumer name information into it
    public static void verifyOrder(WebDriver driver, String name) {
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        //If there is only one table on the page, you dont have to lcoate the table. --//tr/td[2]
        //List<WebElement>namesList = driver.findElements(By.xpath("//tr/td[2]"));

        //type iter, press tab for "for each" loop short cut.
        for (WebElement each : namesList) {
            if (each.getText().equals(name)) {
                Assert.assertTrue(true);
                return;
            }
        }
        //Assert fail method will fail the test when it is called, no matter what.
        Assert.fail("Name: " +name+" does not exist in the list!");
    }


    /*
    • Create a method named printNamesAndCities in SmartBearUtils class.
    • Method takes WebDriver object.
    • This method should simply print all the names in the List of All Orders.
    • Create a new TestNG test to test if the method is working as expected.
    • Output should be like:
    • Name1: name , City1: city
    • Name2: name , City2: city
     */
    public static void printNamesAndCities(WebDriver driver){

        //locating all the names from all the rows and storing in a list of web element
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //we need to locate all the cities from all the rows
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for (int i = 0; i < namesList.size() ; i++) {

            System.out.println("Name"+ (i+1) +": " + namesList.get(i).getText() + ", City"+ (i+1) +": " + citiesList.get(i).getText());

        }


    }

    }



