package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {
    public VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


}
