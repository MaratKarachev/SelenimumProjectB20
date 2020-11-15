package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectingStateFromStateDropdown {

    WebDriver driver;

    //TC #2: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void dropdown_test_1() throws InterruptedException {

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        dropdown.selectByVisibleText("Illinois");
        Thread.sleep(2000);
        dropdown.selectByValue("VA");
        Thread.sleep(2000);
        dropdown.selectByIndex(5);
        Thread.sleep(2000);

        //3. Select Illinois
        //4. Select Virginia
        //5. Select California
        //6. Verify final selected option is California.
        String actualOption = dropdown.getFirstSelectedOption().getText();
        String expectedOption = "California";

        System.out.println(actualOption);

        Assert.assertEquals(actualOption,expectedOption,"States does NOT match");

        //Use all Select options. (visible text, value, index)
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
