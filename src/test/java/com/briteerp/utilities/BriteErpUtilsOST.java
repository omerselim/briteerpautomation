package com.briteerp.utilities;

import com.briteerp.tests.pages.CRM.crmPipelineRevPage;
import com.briteerp.tests.pages.login.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BriteErpUtilsOST {

    public static void navigateToModule(String tab){
        String tabLocator = "//span[@class='oe_menu_text'][contains(text(),'"+tab+"')]";
        SeleniumUtils.clickWithWait(Driver.getDriver(), By.xpath(tabLocator), 5);
//      SeleniumUtils.waitPlease(2);
    }


    public static void login(){
        loginPage login = new loginPage();
        login.userNameElement.sendKeys(ConfigurationReader.getProperty("username"));
        login.passwordElement.sendKeys(ConfigurationReader.getProperty("password"));
        login.loginButtonElement.click();
    }

    public static void logout() {
        loginPage logout=new loginPage();
        logout.ManagerLocator.click();
        logout.logOutLocator.click();
        SeleniumUtils.waitPlease(2);
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
//    public static void waitUntilLoaderScreenDisappear() {
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));
//
//            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
//        }catch (Exception e){
//            System.out.println(e+" :: Loader mask doesn't present.");
//        }
//    }
}
