package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractices {
    //TC#7: Cybertek “month” dropdown default value
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/dropdowns
    //3. Verify default value is always showing the current month
    //o Expected: If currently in June, should show June selected.

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void p7_month_dropdown_default_value_test() {
        //locating the month dropdown
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        //Expected
        String expectedValue = LocalDateTime.now().getMonth().name();
        System.out.println("expectedValue = " + expectedValue);

        //Actual
        String actualValue = monthDropdown.getFirstSelectedOption().getText();
        System.out.println("actualValue = " + actualValue);
        //Assert
        //First way of doing assertion: use .toLowerCase() method for both actual and expected values
        Assert.assertEquals(actualValue.toLowerCase(), expectedValue.toLowerCase());

        //Second way: use equalsIgnoreCase to compare actual and expected values
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));


        //TASK#8:

        //TC#8: Cybertek “month” dropdown list of default values verification
        //1. Do both verifications in the same test
        // 2. Verify list of months are correct as expected.
        //o Expected: Options should contain all 12 months of the year.

        //this line gets all of the options from the dropdown and store the value in a list
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        //Creating a list of strings to store months
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December");

        //Create a new list of Strings called: actualMonthsTexts, and store the texts of web elements into this new list
       /* List<String> actualMonthsTexts = new ArrayList<>();

        for (WebElement each : actualMonthOptions) {
            actualMonthsTexts.add(each.getText());
        }
        */

        //Passing List into assertions:
        //First it will check the size, then it will check the content
        Assert.assertEquals(BrowserUtils.getElementsText(actualMonthOptions),expectedMonthOptions);


    }
}