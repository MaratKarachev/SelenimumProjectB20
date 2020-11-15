package com.cybertek.tests.day11_utils_review_actions;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceTasks {
    /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red".
     */

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void double_click_test() {
        //1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        WebElement iframe = Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']"));
        //2.Switch	to	iframe.
        Driver.getDriver().switchTo().frame(iframe);

        WebElement doubleClickMe = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        //Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.wait(2);
        // 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        actions.moveToElement(doubleClickMe).doubleClick().perform();

        //4.Assert:	Text’s	“style”	attribute	value	contains "red".
        BrowserUtils.wait(1);
        String styleAttribute = Driver.getDriver().findElement(By.xpath("//p[@style]")).getAttribute("style");
        Assert.assertTrue(styleAttribute.contains("red"), "Verification FAILED");
        System.out.println(styleAttribute);

    }

    @Test
    public void hoverTest() {
        /*
        TC	#16:	Hover	Test
        1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        2.Drag	and	drop	the	small	circle	to	bigger	circle.
        3.Assert:	-Text	in	big	circle	changed to:	“You	did	great
         */

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(1);


       // Actions actions = new Actions(Driver.getDriver());
        WebElement draggable = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        actions.dragAndDrop(draggable, target).perform();

        Assert.assertTrue(target.getText().equals("You did great!"), "Verification FAILED!");
    }

    @Test
    public void context_click() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
       // Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(box).contextClick().perform();
        BrowserUtils.wait(2);

        Driver.getDriver().switchTo().alert().accept();

        }
    }

    /*
    TC	#17:	Context	Click	–HOMEWORK
    1.Go	to	https://the-internet.herokuapp.com/context_menu
    2.Right	click	to	the	box.
    3.Alert	will	open.
    4.Accept	alert
    No	assertion	needed	for	this practice.
     */


