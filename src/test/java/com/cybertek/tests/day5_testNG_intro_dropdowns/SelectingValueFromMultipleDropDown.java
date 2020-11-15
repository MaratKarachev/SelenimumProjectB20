package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectingValueFromMultipleDropDown {
    //TC #4: Selecting value from multiple select dropdown
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1500);
    }

    @Test
    public void selectingValue() throws InterruptedException {
        //3. Select all the options from multiple select dropdown.
        Select allDropDowns = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        Thread.sleep(1500);
        //select[@name='Languages']/option[1]
        for (int i = 0; i <= 5; i++) {
            allDropDowns.selectByIndex(i);
        }
        Thread.sleep(1500);
        List<WebElement> allSelectedValues = allDropDowns.getAllSelectedOptions();
        Thread.sleep(1500);
        //4. Print out all selected values.
        for (WebElement each : allSelectedValues) {
            System.out.println(each.getText());
        }
        Thread.sleep(1500);
        //5. Deselect all values.
        allDropDowns.deselectAll();

    }


}




