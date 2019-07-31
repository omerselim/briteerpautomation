package com.briteerp.tests.components.crm;

import com.briteerp.pages.login.loginPage;
import com.briteerp.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class crmDraft {
    WebDriver driver;

    String usernameLocator ="login";
    String passwordLocator ="password";
    String loginLocator = "//button[@type='submit']";
    String CRMTabLocator = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[5]";
    String ListButtonLocator ="//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String pipelineLocator="/html/body/div[1]/div[2]/div[1]/ol/li";
    String beforeDeleteLocator = "//span[@class='o_pager_limit']";
    String vendorBottonLocator="//tr[1]//td[1]";
    String ActionButtonLocator="//button[contains(text(),'Action')]";
    String DeleteButtonLocator="//a[contains(text(),'Delete')]";
    String okButtonLocator ="//span[contains(text(),'Ok')]";
    String afterDeleteNumberLocator = "//span[@class='o_pager_limit']";


    @BeforeMethod
    public void setup(){
        // i set up webdrivermanager to call browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        // i set up window to maximize
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // open the log in page
        driver.get("http://34.220.250.213/web/login");
    }
    @Test
    public void UserCredential() {
        loginPage.login();
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        SeleniumUtils.waitPlease(2);
        // ******** 3 **********8
        //find  the name CRM tab lcoator
        driver.findElement(By.xpath(CRMTabLocator)).click();
        SeleniumUtils.waitPlease(3);
        // ********** 4 **************
        // find ListButtonLocator
        driver.findElement(By.xpath(ListButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        //********** 5 *********
        // we should see All vendorLists
        driver.findElement(By.xpath(pipelineLocator));
        SeleniumUtils.waitPlease(3);
        // find numbers locator beforeDelete Vendor from list
        String beforeNumStr = driver.findElement(By.xpath(beforeDeleteLocator)).getText();
        System.out.println("----------------------------------------------------------");
        System.out.println("The number of opportunities before deleting :"+beforeNumStr);
        // ********* 6 **********
        // find checkboxButon locator to delete Vendor form list
        driver.findElement(By.xpath(vendorBottonLocator)).click();
        SeleniumUtils.waitPlease(3);
        // ********* 7 ***********
        // we should see Action button and find locator
        driver.findElement(By.xpath(ActionButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        //********** 8 **********
        //  in dropdown tab we should go delete button find locator
        driver.findElement(By.xpath(DeleteButtonLocator)).click();
        SeleniumUtils.waitPlease(3);
        // *********** 9 ***********
        // we should see ok button in the pop up windows
        driver.findElement(By.xpath(okButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        // ************ 10 *********
        // we after delete vendor from list we should check numbers
        String afterNumStr = driver.findElement(By.xpath(afterDeleteNumberLocator)).getText();
        //print out the number string
        System.out.println("The number of opportunities after deleting :"+afterNumStr);
        System.out.println("--------------------------------------------------------");
        //change the string to the Integer
        int beforeNum=Integer.parseInt(beforeNumStr);
        int afterNum=Integer.parseInt(afterNumStr);
        // and check the number before delete and after delete, if the number before delete is bigger then the number
        //after delete , your delete action is successful.
        Assert.assertTrue(beforeNum>afterNum);





    }

}