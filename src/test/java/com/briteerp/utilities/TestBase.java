package com.briteerp.utilities;

import com.briteerp.pages.login.loginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    //should be public/protected !!!!
    public WebDriver driver;
    public Actions action;

    @BeforeClass
    public void setup(){
        driver = Driver.getDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitwait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }
    @BeforeMethod
    public void login(){
        System.out.println("==============================\nProseding login to page\n------------------------------");
        loginPage.login();
        SeleniumUtils.waitPlease(2);
    }
    @AfterMethod
    public void logout(){
        System.out.println("==============================\nProseding logout from page\n------------------------------");
        loginPage.logout();
        SeleniumUtils.waitPlease(2);
    }
    @AfterClass
    public void teardown(){
        Driver.closeDriver();
    }


}
