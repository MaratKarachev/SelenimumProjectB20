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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US1MessageTabUnderActiveStream {
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
        WebElement messageButton = driver.findElement(By.xpath("//span[.='Send message …']"));
        messageButton.click();
        BrowserUtils.wait(2);


    }
    //1. User should be able to click on upload files icon to upload files and pictures from local disks,
    // download from external drive, select documents from bixtrix24, and create files to upload.
    @Test
    public void AC_1_click_on_upload_files_icon() {
        WebElement uploadFilesIcon = driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']"));
        uploadFilesIcon.click();

        List<WebElement>actualUploadingFileOption = driver.findElements(By.xpath("//table[@class='diskuf-selector-table wd-fa-add-file-light-table']"));
        BrowserUtils.wait(5);
        String actualOption = "";

        for (WebElement eachOption:actualUploadingFileOption){
            actualOption+=eachOption.getText();
        }

        String expectedOptions="Upload files and images\n" +
                "Drag files here to upload\n" +
                "Select document from Bitrix24\n" +
                "Available libraries\n" +
                "Download from external drive\n" +
                "Office 365\n" +
                "Google Drive\n" +
                "Dropbox\n" +
                "Create using Office 365\n" +
                "Document\n" +
                "Spreadsheet\n" +
                "Presentation";
        Assert.assertEquals(actualOption,expectedOptions);


    }
    //2. User should be able to add users from selecting contact from E-mail user,
    // Employees and Departments and Recent contact lists.
    @Test
    public void AC_2_click_on_add_users(){

        WebElement addMoreButton = driver.findElement(By.xpath("//span[@class='feed-add-post-destination-text']"));
        addMoreButton.click();
        BrowserUtils.wait(1);

        List<WebElement>addingOptions = driver.findElements(By.xpath("//a[@href='#switchTab']"));
        String actualOptions = "";
        for(WebElement each:addingOptions){
            each.click();
            actualOptions+=each.getText()+"\n";
        }

        String expectedOptionsText = "Recent\n" +
                "Employees and departments\n" +
                "E-mail users"+"\n";

        Assert.assertEquals(actualOptions,expectedOptionsText,"Text do NOT match");

    }
    //3. User should be able to attach link by clicking on the link icon.
    @Test
    public void AC_3_ability_to_attach_theLink(){
        WebElement messageButton = driver.findElement(By.xpath("//span[.='Message']/span"));
        messageButton.click();
        WebElement linkIcon = driver.findElement(By.xpath("//span[@title='Link']"));
        linkIcon.click();
        WebElement insertText = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        insertText.sendKeys("GoogleLink");
        BrowserUtils.wait(2);
        WebElement attachLinkUrl = driver.findElement(By.id("linkidPostFormLHE_blogPostForm-href"));
        attachLinkUrl.sendKeys("www.google.com");
        BrowserUtils.wait(2);
        WebElement saveButton = driver.findElement(By.name("undefined"));
        saveButton.click();
        //extra
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();
    }

        //4. User should be able to insert videos by clicking on the video icon
    // and entering the video URL.
        @Test
        public void ac4_insert_video(){
            WebElement insertVideo = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[3]/div[2]/span[3]/span[1]/i[1]"));
            insertVideo.click();
            BrowserUtils.wait(3);
            WebElement actualVideoSource = driver.findElement(By.xpath("//label[contains(text(),'Video source:')]"));
            String expectedVideoSource = "Video source:";
            Assert.assertTrue(actualVideoSource.getText().equals(expectedVideoSource));
            WebElement linkLine = driver.findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']"));
            linkLine.sendKeys("https://vimeo.com/259411563");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            BrowserUtils.wait(10);
            WebElement saveButton = driver.findElement(By.xpath("//input[@id='undefined']"));
            saveButton.click();
            // WebElement iframe = driver.findElement(By.id("bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm"));
            // driver.switchTo().frame(iframe);
            // WebElement videoDownloadedCheck = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/iframe[1]"));
            // Assert.assertTrue(videoDownloadedCheck.isDisplayed(),"Video wasn't downloaded");
            WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
            sendButton.click();
        }

    //7. User should be able to click on Visual Editor and see the
    // editor text-bar displays on top of the message box.
    @Test
    public void AC_7_click_on_visual_editor(){
        WebElement visualEditor = driver.findElement(By.id("lhe_button_editor_blogPostForm"));
        visualEditor.click();
        BrowserUtils.wait(1);
        visualEditor.click();

        WebElement editorTextBar = driver.findElement(By.id("bx-html-editor-tlbr-idPostFormLHE_blogPostForm"));
        Assert.assertTrue(editorTextBar.isDisplayed(),"Verification FAILED!");
    }

    //8. User should be able to click on the Topic icon to see the Message Topic text
    // box displays on top of the message box.
    @Test
    public void AC_8_topicIcon(){
        BrowserUtils.wait(1);
        WebElement topicButton=driver.findElement(By.xpath("//span[@title='Topic']"));
        topicButton.click();

        WebElement topicBox=driver.findElement(By.xpath("//input[@id='POST_TITLE']"));

        Assert.assertTrue(topicBox.isDisplayed(), "Topic box is not displayed verification FAILED!");
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(5);
       // driver.close();
    }

/*

 */
}
