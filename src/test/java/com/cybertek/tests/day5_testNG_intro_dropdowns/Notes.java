package com.cybertek.tests.day5_testNG_intro_dropdowns;

public class Notes {
    /*
    September 13th, SUNDAY
Today's schedule
#1- Brief recap of yesterday
#2- How do you handle dynamic web elements
#3- P05_Checkbox task
#4- Introduction to TestNG
#5- How to handle dropdowns
=============================
# RECAP
-CSS SELECTOR
    - #1 syntax:
        tagName[attribute='value']

        -> looks for the tags with given attribute and value
        -> this syntax does not have any limitation. You can basically use any attribute and value with this syntax.
    - #2 syntax:
        - tagName#idValue
        - tagName.classValue
        -> This syntax looks for the given idValue or class attribute value.
        -> Therefore it is limited to locate with ONLY id or class attribute value.
    - How do you go from parent to child using css selector?
        - We need to use > sign to go from parent to child when using css selector.
    - How do you go from child to parent using css selector?
        - You don't. You cannot go from child to parent using css selector.
-XPATH LOCATORS
    -> How many types of xpath do we have?
        - There are 2 types of xpath.
    #1-> Absolute xpath
        -> Starts with single slash --> /
        -> Starts from the root element, and goes 1 by 1 to the desired web element
        -> Therefore it is not stable, and reliable.
        -> You should avoid using it unless you do not have any other option.
    #2-> Relative xpath
        -> Starts with double slash --> //
        -> Starts from anywhere in the HTML code
        -> It is a lot harder for your relative xpath to break compared to absolute xpath.
    Common locators:
    #1- //tagName[@attribute='value'] -> locates web element with given tagname, attribute and value.
    #2- //tagName[.='text'] -> this one is looking for the text of the given tagname
    #3- //*[@attribute='value'] --> it only looks for the given attribute and value. does not care about the tagname.
P.I.Q
HOW DO YOU HANDLE DYNAMIC WEB ELEMENTS?
HOW DO YOU HANDLE WEB ELEMENTS WITH DYNAMIC ATTRIBUTE VALUES?
-> I use 3 methods that comes from xpath.
    - contains method, starts-with, and ends-with method.
    #4- //div[contains(@attribute, 'value')]
    #5- //div[starts-with(@attribute, 'value')]
    #6- //div[ends-with(@attribute, 'value')]
    <div name="abd1234212" id="123123asfc"> </div>
    -> locator for the dynamic attribute value of google search button
    //input[contains(@data-ved, 'UDCA0')]
PREFERENCE OF CREATING LOCATOR (AT WORK)
    -> Go for id if you have it (make sure it is not dynamic)
    -> If there is class attribute value, I just check using cssSelector (.) if it is unique or not. If it is unique I use driver.findElement(By.className());
    -> If the above is not working, and the first 6 locators are not working I go for XPATH locator.
BREAK UNTIL: 10.07AM CST, 11.07AM EST
-FINDELEMENTS VS FINDELEMENT
-How do you handle checkboxes and radio buttons

    #1 - We locate them as any other web element
    #2 - If we want to check the default value, we use .isSelected() method
    #3 - If we want to select or unselect, we just use .click() method
    .isSelected() ->
        - You use it when you need to check the current state of the checkbox.
        - Return type is boolean
        - It will return true if the check box is currently selected. If not it will return false.
    .isEnabled() ->
        - You use it when you need to check if the given web element is enabled or not.
        What is enabled?
            - If it is clickable or not. If it is clickable, it means it is enabled.
        - Return type is boolean
        - It will return true if the check box is currently ENABLED. If not it will return false.

        =========================================
STEPS TO IMPLEMENT TESTNG
    1- Go to mvnrepository : https://mvnrepository.com/
    2- Search for testng
    3- Click to first result: TestNG
    4- Get the most update TestNG dependency
    5- Add it into your project pom.xml file
What are annotations in TestNG?
    -> Annotations are a way of controlling the flow of TestNG.
    @Test :
        - This annotation will make the java method a TestNG test.
        - When we use this annotation we will be able to treat that java method, as a testNG test.
        - And we can run it solo, or as a part of a bigger test suite.
        - By default tests are running in the alphabetical order. But we can specify priority in between them
        - Each test is indepent from each other. But we can create dependency in between the tests.
    @BeforeMethod:
        - This annotation will make the method that it is used run ONCE before each TEST in the class.
        - So however many tests that I have, the before method will run that many times.
        - it is usually used to do some setup for our tests.
            For ex:
                - Setting up the driver
                - We can maximize window
                - We can put implicit wait
    @AfterMethod:
        - Aftermethod will make the method run after each test in the class.
        - It is usually used to tearDown things. For ex: closing the browser, quitting the browser etc.
        - Aftermethod will run as many times as the number of the tests you have.
    @BeforeClass:
        - BeforeClass will run ONCE before everything else in the class.
        - Any setup stuff can be handled in the before class.
    @AfterClass:
        - AfterClass will run ONCE AFTER everything is done in the class.
        - Any tearDown(closing) stuff can be handled in this method.
WHAT IS AN ASSERTION?
    - Assertions are used to verify if a test is passing or failing.
    -> assertTrue
    -> assertEquals
    .assertTrue(boolean):
        - assertTrue method is one of the assertion methods coming from TestNG library.
        - AssertTrue accepts a boolean condition.
        - If the boolean condition is true, the test will pass.
        - If the boolean condition is FALSE, the test will FAIL.
    .assertEquals(expected, actual);
        - assertEquals method is expecting 2 arguments to compare with each other.
        - it will check given 2 arguments against each other. If anything is not matching, it will fail the test.
        -> In all of the TestNG assertions, the last argument we pass as a String will be accepted as an addition message.
        -> This message will be ONLY printed out IF the assertion fails.
        -> Otherwise it will not be printed out.

     */


}
