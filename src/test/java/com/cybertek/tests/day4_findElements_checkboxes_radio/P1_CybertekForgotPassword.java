package com.cybertek.tests.day4_findElements_checkboxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_CybertekForgotPassword {

    public static void main(String[] args) {


        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        //b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text
        WebElement text = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        //e. “Retrieve password” button
        //Using css selector to locate this button
        //Option #1: using this syntax --> button#form_submit
        //Option #2: using this syntax --> button[id='form_submit']
        //Option #3: using this syntax --> button[class='radius']
        //Option #4: button.radius
        WebElement retrivePasswordButton = driver.findElement(By.cssSelector("button.radius"));

        //f. “Powered by Cybertek School” text
        WebElement linkText = driver.findElement(By.xpath("//a[.='Cybertek School']"));
        WebElement poweredByDiv = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        System.out.println("linkText = " + linkText);
        System.out.println("poweredByDiv = " + poweredByDiv);


        //4. Verify all WebElements are displayed.
        // .isDisplayed --> returns true if given web element is displayed
        // .isDisplayed --> return false if given web element is not displayed
        if(header.isDisplayed()&&homeLink.isDisplayed() && text.isDisplayed() && emailInput.isDisplayed() &&
                retrivePasswordButton.isDisplayed()&& poweredByDiv.isDisplayed() ){
            System.out.println("All web elements are displayed. Verification PASSED!");
        }else{
            System.out.println("One ore more of the web elements are not displayed. Verification Failed!");
        }
    }
}
