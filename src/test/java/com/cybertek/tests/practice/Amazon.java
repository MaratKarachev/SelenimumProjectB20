package com.cybertek.tests.practice;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Amazon {

    @Test
    public void Altay_Task() {


        Driver.getDriver().get("https://www.amazon.com/");
        WebElement search = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Animal");
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit'][1]"));
        submitButton.click();

    }
}