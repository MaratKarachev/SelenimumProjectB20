package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPageElements {

    public DynamicallyLoadedPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);}

        //Locate start button
        @FindBy(xpath = "//button[.='Start']")
        public WebElement startButton;

        //Locate username input box
        @FindBy(id="username")
        public WebElement usernameInputBox;

        @FindBy(id = "//div[@id='loading']")
        public WebElement loadingBar;

        @FindBy(id = "pwd")
        public WebElement passwordInputBox;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement submitButton;

        @FindBy(id = "flash")
        public WebElement errorMessage;

    }

