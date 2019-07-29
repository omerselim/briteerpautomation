/*
IN-06  :  Accessing inventory main page

Step-01	open URL	http://54.148.96.210/web/login
        Should be able to access BriteERP log in page.
Step-02	Click and Enter valid email address to the Email-Box	in3@info.com
        Should be able to Click and Enter valid email adress to the Email Box
Step-03	Click and Enter valid password to the Password-Box	alsfuh7we72
        Should be able to Click and Enter valid password to the Password-Box
Step-04	Click Log in box to enter to the main page
        Should be able to Click Log in box to enter to the main page
Step-05	Click Inventory Tab to open the Inventory page
        Should be able to see the Inventory page
Step-06	Click Discuss tab to open the Discuss page
        Should be able to see the Discuss page
Step-07	Click Inventory tab to open the Inventory page
        Should be able to see the Inventory page
Step-08	Click Calendar tab to open the Calendar page
        Should be able to see the Calendar page
Step-09	Click Inventory tab to open the Inventory page
        Should be able to see the Inventory page
 */
package com.briteerp.tests.components.inventory;
import com.briteerp.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Briteerp_IN06 {

    WebDriver driver;
    String usernameLoginLocator = "login";
    String passwordLoginLocator = "password";
    String loginLocator = "*[type='submit']";
    String inventoryLocator = "(//span[contains(text(),'Inventory')])[1]";
    String discussLocator = "(//span[contains(text(),'Discuss')])[1]";
    String calendaryLocator = "(//span[contains(text(),'Calendar')])[1]";
    String ManagerLocator       = "oe_topbar_name";
    String logOutLocator        = "a[data-menu='logout']";

/*
Step-01	open URL	http://54.148.96.210/web/login
        Should be able to access BriteERP log in page.
 */
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://54.148.96.210/web/login");
    }

/*
Step-02	Click and Enter valid email address to the Email-Box	in3@info.com
        Should be able to Click and Enter valid email adress to the Email Box
Step-03	Click and Enter valid password to the Password-Box	alsfuh7we72
        Should be able to Click and Enter valid password to the Password-Box
Step-04	Click Log in box to enter to the main page
        Should be able to Click Log in box to enter to the main page
*/
    @BeforeMethod
    public void login(){
        driver.findElement(By.id("login")).sendKeys("in3@info.com");
        driver.findElement(By.id("password")).sendKeys("alsfuh7we72");
        driver.findElement(By.cssSelector(loginLocator)).click();
        SeleniumUtils.waitPlease(2);
    }


/*
Step-05	Click Inventory Tab to open the Inventory page
        Should be able to see the Inventory page
Step-06	Click Discuss tab to open the Discuss page
        Should be able to see the Discuss page
Step-07	Click Inventory tab to open the Inventory page
        Should be able to see the Inventory page
Step-08	Click Calendar tab to open the Calendar page
        Should be able to see the Calendar page
Step-09	Click Inventory tab to open the Inventory page
        Should be able to see the Inventory page
*/
    @Test
    public void Inventory() {

        driver.findElement(By.xpath(inventoryLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(driver.getTitle(), "Inventory - Odoo");

        driver.findElement(By.xpath(discussLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(inventoryLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(driver.getTitle(), "Inventory - Odoo");

        driver.findElement(By.xpath(calendaryLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(inventoryLocator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(driver.getTitle(), "Inventory - Odoo");
    }



    @AfterMethod
    public void logout() {
        driver.findElement(By.className(ManagerLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(logOutLocator)).click();
        SeleniumUtils.waitPlease(2);
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
