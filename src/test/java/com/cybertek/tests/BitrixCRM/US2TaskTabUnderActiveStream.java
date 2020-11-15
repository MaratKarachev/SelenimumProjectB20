package com.cybertek.tests.BitrixCRM;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US2TaskTabUnderActiveStream {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("helpdesk13@cybertekschool.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        WebElement taskButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        taskButton.click();
        BrowserUtils.wait(2);
    }

    //1. User should be able to click on "High Priority" checkbox to set the current
    // task to a top priority task.
    @Test
    public void AC_1_click_on_high_priorityCheckBox() {
        WebElement highPriorityCheckbox = driver.findElement(By.xpath("//input[@id='tasks-task-priority-cb']"));
        highPriorityCheckbox.click();
        Assert.assertTrue(highPriorityCheckbox.isSelected(), "VERIFICATION FAILED");
    }

    //2. User should be able to click on Visual Editor and see the editor text-bar
    // displays on top of the message box.
    @Test
    public void AC_2_visual_editor() {
        WebElement visualEditor = driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-lifefeed_task_form']"));
        boolean visualEditorBeforeClick = visualEditor.isDisplayed();//true
        BrowserUtils.wait(1);
        WebElement visualEditorButton = driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']"));
        visualEditorButton.click();
        boolean visualEditorAfterClick = visualEditor.isDisplayed();//false
        boolean result = false;
        if (visualEditorBeforeClick == true && visualEditorAfterClick == false) {
            result = true;
        }
        Assert.assertTrue(result, "Verification FAILED");

    }

    //3. User should be able to click on upload files icon to upload files and pictures from local disks,
    // download from external drive, select documents from bixtrix24, and create files to upload.
    /*@Test
    public void ac3_upload_files(){
        WebElement uploadFilesButton = driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']"));
        uploadFilesButton.click();
        WebElement uploadFilesAndImages=driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[1]"));
        uploadFilesAndImages.click();
        WebElement selectDocFromBitrix = driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/span[1]/span[1]/span[1]/span[1]"));
        selectDocFromBitrix.click();
        BrowserUtils.wait(3);
        WebElement cancel1 = driver.findElement(By.xpath("//body/div[@id='DiskFileDialog']/div[3]/span[2]"));
        cancel1.click();
        WebElement downloadFromExternalDrive = driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/span[1]/span[1]/span[1]/span[1]"));
        downloadFromExternalDrive.click();
        BrowserUtils.wait(3);
        WebElement cancel2 = driver.findElement(By.xpath("//body/div[@id='DiskFileDialog']/div[3]/span[2]"));
        cancel2.click();
        WebElement office365 = driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[3]/td[3]/span[1]/span[1]/span[1]/span[1]"));
        office365.click();
        WebElement googleDocs = driver.findElement(By.xpath("//body/div[@id='menu-popup-disk_open_menu_with_services']/div[@id='popup-window-content-menu-popup-disk_open_menu_with_services']/div[1]/div[1]/a[3]/span[2]"));
        googleDocs.click();
        BrowserUtils.wait(3);
       // WebElement document365 = driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/table[1]/tbody[1]/tr[3]/td[3]/span[1]/span[1]/span[2]/a[1]/span[2]"));
        //document365.click();
    }


     */

    //5. User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown.
    @Test
    public void AC_5_AddMention() {
        WebElement taskTab = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        taskTab.click();
        WebElement addMentionButton = driver.findElement(By.id("bx-b-mention-task-form-lifefeed_task_form"));
        addMentionButton.click();
        WebElement contacts = driver.findElement(By.xpath("//div[@class='bx-finder-box-item-t7-name']"));
        contacts.click();
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(5);
       // driver.close();
    }

}