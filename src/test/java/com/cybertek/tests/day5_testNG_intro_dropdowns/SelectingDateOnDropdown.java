package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectingDateOnDropdown {

    //TC #3: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");


    }

    @Test
    public void dropdown() throws InterruptedException {
        Select dropdownOfTheYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        dropdownOfTheYear.selectByVisibleText("1921");

        Select dropdownOfTheMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        dropdownOfTheMonth.selectByValue("11");

        Select dropdownOfTheDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dropdownOfTheDay.selectByIndex(0);

        String date = dropdownOfTheMonth.getFirstSelectedOption().getText() + " " + dropdownOfTheDay.getFirstSelectedOption().getText() +
                " , " + dropdownOfTheYear.getFirstSelectedOption().getText();
        System.out.println(date);
    }

    //3. Select “December 1 , 1921” and verify it is selected.
    //   Select year using: visible text
    //   elect month using: value attribute
    //   Select day using: index number


}
