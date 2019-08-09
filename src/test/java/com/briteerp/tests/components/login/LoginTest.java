package com.briteerp.tests.components.login;
import com.briteerp.pages.login.LoginPage;
import com.briteerp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    Pages pages = new Pages();

    @Test
    public void validCredential() {

        //this is required, otherwise you will get null pointer exception
        for (int i=1; i<=pages.loginPage().userNames.size(); i++) {                                                 // .login.userNames.size()
            extentLogger = report.createTest("Login as a Event Scrum Manager #" + i);
            pages.loginPage().login(pages.loginPage().userNames.get(i-1), pages.loginPage().password);
            SeleniumUtils.waitPlease(3);
            String expectedTitle="#Inbox - Odoo";
            String actualTitle=Driver.getDriver().getTitle();
            extentLogger.info("Actual title is :"+actualTitle);

            Assert.assertTrue(expectedTitle.contains(actualTitle));
            pages.loginPage().logout();
            extentLogger.pass("It has been verified that Main Page title is \""+expectedTitle+"\".");
        }

    }



}