package com.cybertek.tests.day4_findElements_checkboxes_radio.task.PracticeCybertek;

/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to "Add Element" button
4. Verify "Delete" button is displayed after clicking.
5. Click to "Delete" button.
6. Verify "Delete" button is NOT displayed after clicking.
USE XPATH and/or CSS Selector LOCATOR FOR ALL WEBELEMENT LOCATORS
Better if you do with both for practice purposes.
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        //3. Click to "Add Element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        //tagName [@attribute='value']
        addElementButton.click();

        //4. Verify "Delete" button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        //tagName [@attribute='value']
        //System.out.println(deleteButton.getText());
        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is NOT displayed");
        }

        Thread.sleep(3000);

        //5. Click to "Delete" button.
        deleteButton.click();

        //6. Verify "Delete" button is NOT displayed after clicking.
        try {
            System.out.println("deleteElement = " + !deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("deleteElement = is not displayed: " + true);
        }
        driver.close();
    }
    }

