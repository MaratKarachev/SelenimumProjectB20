package com.cybertek.tests.day4_findElements_checkboxes_radio.task.PracticeCybertek;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {

    /*
    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.
     */
    public static void main(String[] args) {


        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        // a. “Home” link
        //Css locator solution:
        WebElement homeButton = driver.findElement(By.cssSelector("a[class ='nav-link']"));
        if(homeButton.isDisplayed()){
            System.out.println("Home button is displayed");
        }else{
            System.out.println("Home button is NOT displayed");
        }

        //Xpath locator solution:
        WebElement homeButton2 = driver.findElement(By.xpath("//a[@class='nav-link']"));
        if(homeButton2.isDisplayed()){
            System.out.println("Home button 2 is displayed");
        }else{
            System.out.println("Home button 2 is NOT displayed");
        }

       // b. “Forgot password” header
        //Xpath locator solution:
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        if(forgotPassword.isDisplayed()){
            System.out.println("Forgot password is displayed");
        }else{
            System.out.println("Forgot password is NOT displayed");
        }

        //Css locator solution:
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("h2"));
        //System.out.println(forgotPassword.getText());
        if(forgotPassword2.isDisplayed()){
            System.out.println("Forgot password 2 is displayed");
        }else{
            System.out.println("Forgot password is NOT displayed");
        }

        //c. “E-mail” text
        // Css locator solution:
        WebElement Email = driver.findElement(By.cssSelector("label[for='email']"));
        //System.out.println(Email.getText());
        if(Email.isDisplayed()){
            System.out.println("Email is displayed");
        }else{
            System.out.println("Email is NOT Displayed");
        }

        // Xpath locator solution:
        WebElement Email2 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));
        if(Email2.isDisplayed()){
            System.out.println("Email 2 is displayed");
        }else{
            System.out.println("Email is NOT Displayed");
        }

        //d. E-mail input box
        //Css locator solution:
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text]"));
        if(emailInputBox.isDisplayed()){
            System.out.println("Email input box is displayed");
        }else{
            System.out.println("Email input box is NOT displayed");
        }

        //Xpath locator solution:
        WebElement emailInputBox2 = driver.findElement(By.xpath("//input[@type='text']"));
        if(emailInputBox2.isDisplayed()){
            System.out.println("Email input box 2 is displayed");
        }else{
            System.out.println("Email input box is NOT displayed");
        }

        //e. “Retrieve password” button
        //Css selector solution:
        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
       if(retrievePassword.isDisplayed()){
           System.out.println("Retrieve password button is displayed");
       }else{
           System.out.println("Retrieve password button is NOT displayed");
       }

       //Xpath locator solution:
        WebElement retrievePassword2 = driver.findElement(By.xpath("//i[contains(@class,'icon-2x icon-signin')]"));
        if(retrievePassword2.isDisplayed()){
            System.out.println("Retrieve password button 2 is displayed");
        }else{
            System.out.println("Retrieve password button is NOT displayed");
        }

        //f. “Powered by Cybertek School” text
        //Css locator solution:
        WebElement poweredByCybertek = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        if(poweredByCybertek.isDisplayed()){
            System.out.println("Powered by Cybertek text is displayed");
        }else{
            System.out.println("Powered by Cybertek text is NOT displayed");
        }

        //Xpath locator solution:
        WebElement poweredByCybertek2 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if(poweredByCybertek2.isDisplayed()){
            System.out.println("Powered by Cybertek 2 text is displayed");
        }else{
            System.out.println("Powered by Cybertek 2 text is NOT displayed");
        }

        //4. Verify all WebElements are displayed.
        //Css locator solution:
        WebElement allWebElements = driver.findElement(By.cssSelector("html[class='no-js']"));
        //System.out.println(allWebElements.getText());
        if(allWebElements.isDisplayed()){
            System.out.println("All web elements are displayed");
        }else{
            System.out.println("All web elements are NOT displayed");
        }

        WebElement allWebElements2 = driver.findElement(By.xpath("//html[contains(@class,'no-js')]"));
        if(allWebElements2.isDisplayed()){
            System.out.println("All web elements2  are displayed");
        }else{
            System.out.println("All web elements2 are NOT displayed");
        }

        System.out.println("allWebElements2 = " + allWebElements2.getText());

        driver.close();

    }
    }

