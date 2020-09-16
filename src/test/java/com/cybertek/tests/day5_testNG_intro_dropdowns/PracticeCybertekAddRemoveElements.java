package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeCybertekAddRemoveElements {
    public static void main(String[] args) {


        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschoo".com/add_remove_elements/
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick = 'addElement()']"));

        for (int i = 1; i <= 50; i++) {
            addElement.click();
        }

        //4. Verify 50 “Delete” button is displayed after clicking.

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int numberOfDeleteButtons = deleteButtons.size();
        if (numberOfDeleteButtons == 50) {
            System.out.println("50 Delete buttons displayed!");
        } else {
            System.out.println("50 Delete buttons is NOT displayed!");
        }
        //5. Click to ALL “Delete” buttons to delete them.
        for (WebElement eachDeleteButton : deleteButtons) {
            eachDeleteButton.click();
        }
        //6. Verify “Delete” button is NOT displayed after clicking.
    try {
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (!deleteButton.isDisplayed()) {
            System.out.println("Delete button is NOT displayed, verification PASSED!");
        } else {
            System.out.println("Delete button is displayed, verification FAILED!");
        }

    }catch (NoSuchElementException e){
        System.out.println("There is no DELETE Button, Verification PASSED");
    }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method.
    }
}
