package com.cybertek.tests.day12_review_jsexecutor_pom;

public class Notes {

    /*
Oct 13th, Tuesday
OFFICE HOURS:
    - Actions review
    - Solve actions tasks 2-3-4
- Selenium Library last day tomorrow.
- But UI-Test-Automation section will continue for a few more week.
- Rest of the topics:
    - JavaScriptExecutor
    - Page object model design pattern (introduction)
    - WebDriverWait (Synchronization)
--------------------------------
    Actions :
        What is Actions? / Why do we use it?
            -> Actions class comes from Selenium Library to emulate complex mouse and keyboard actions.
                - such as:
                    - moveToElement
                    - contextClick(right click)
                    - doubleClick
                    - sendKeys
                    - perform() -> for performing all the methods
        Which method we use to emulate "hovering over" action?
            - moveToElement()
        How do we use it? (How do we implement it into our code)
            - We create the instance of the Actions class, and pass the Driver instance into constructor.
            syntax:
                Actions actions = new Actions(driver);
                actions.moveToElement(link).perform();
                actions.contextClick(link).perform();
                actions.doubleClick(link).perform();
        How do we scroll using Actions class?
            - moveToElement()
            - When we pass the element that is not in the screen, this method scrolls to that web element into the page.
            - Whatever WebElement we pass into this method, will be scrolled and visible in the page.
TODAY'S SCHEDULE
    - ALL ACTIONS PRACTICES HAS BEEN SOLVED IN THE TODAY'S REVIEW SESSION.
    1- Upload practice
    2- JavaScriptExecutor
    3- Page object model design pattern
1- Uploading using Selenium:
    1- We locate the upload web element using any locator
    2- We send the path of the file we want to upload to the upload web element
    We will NOT be clicking on the upload web element.
==============================================
JAVASCRIPT EXECUTOR
    - What is JavaScript Executor?
        - JS Executor is just an interface in Selenium Library.
        - It just has two methods in it.
    - Why do we use it
        - It allows us to pass/use/inject "javascript" code in our java/selenium code.
        - We might need it for scrolling, or clicking
    - How do we use it
        - We MUST cast our driver type to JavaScriptExecutor type.
        - After casting our driver, we can reach the methods coming from this interface.
        1- We create instance of JSExecutor and cast our driver type to it
        JavaScriptExecutor js = (JavaScriptExecutor)Driver.getDriver();
        2- use the methods that come from this interface
        js.executeScript("javascript function as a string", Obj obj);
        arg1 -> any javascript function that we want to pass
        arg2 -> where do we want to apply this function to
P.I.Q. How many ways do you know scrolling in Selenium?
    #1- Using Actions moveToElement(given element) method.
    #2- JSExecutor -->
         js.executeScript("window.scrollBy(0, 500)");
    #3- JSExecutor -->
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);
===========================
What design pattern we used so far?
    - Singleton Design Pattern
        - Singleton Design Pattern allows us to return the same instance from the class every time we call the constructor
        - We achieve singleton design pattern by creating a private constructor then creating a getter for our object.
PAGE OBJECT MODEL DESIGN PATTERN
-> WHAT IS PAGE OBJECT MODEL?
    - Creating a class for each page of the AUT (application under test), and storing related web elements into that page.
        - LoginPage
            -username
            -password
            -loginbutton
            -informationText
        - LandingPage
        - HomePage
        - ViewAllProductsPage
        - OrderPage
            - Product
            - Quantity
            - PricePerUnit
WHY ARE WE USING PAGE OBJECT MODEL?
    -> Advantages of Page Object Model:
        - Reusable web elements/less code/ non-repeating code
        - We make our project very organized: easy to maintain
        - Readable
HOW ARE WE IMPLEMENTING PAGE OBJECT MODEL DESIGN PATTERN?
    -> Create a package named 'pages' in the same level with tests, and utilities package.
    -> Create a class for each page of AUT.
        - LoginPage
        - LandingPage
        - WhateverPage
    -> We need to create a constructor, then we pass one line in our constructor.
        ->PageFactory.initElements(Driver.getDriver(), this);
        public class LoginPage{
            public LoginPage(){
                PageFactory.initElements(Driver.getDriver(), this);
            }
            @FindBy(id = "demo")
            public WebElement usernameInput;
        }
    -> We need to locate web Elements using @FindBy annotation.
    -> When we want to use any web element, we basically create the object of that class, and call the web element through the instance of the class.
    LoginPage loginPage = new LoginPage();
    loginPage.usernameInput.sendKeys();


     */
}
