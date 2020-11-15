package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SmartBearPractices_9_10_11 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);

    }

    /*
    TC #9: SmartBear delete order
    1. Open browser and login to SmartBear
    2. Delete “Mark Smith” from the list
    3. Assert it is deleted from the list
     */
    @Test
    public void p9_delete_order_task() throws IOException {
        //Creating properties object to be able to read properties file
        Properties properties = new Properties();

        //Opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //Loading the file into properties object
        properties.load(file);

        //--> URL FROM CONFIGURATION PROPERTIES
        String url = properties.getProperty("smartBearUrl");

        driver.get(url);
        SmartBearUtilities.loginToSmartBear(driver);
        BrowserUtils.wait(2);
        //locate the checkbox for 'Mart Smith' and click it
        WebElement markSmithCheckbox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        markSmithCheckbox.click();

        //locate 'Delete selected' button and click to it
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //assert 'Mark Smith' is not in the table
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement each : namesList) {
            Assert.assertFalse(each.getText().equals("Mark Smith"));

        }

    }

}