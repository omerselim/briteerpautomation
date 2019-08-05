package com.briteerp.tests.components.login;
import com.briteerp.pages.login.LoginPage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage login = new LoginPage();

    @Test
    public void validCredential() {
        //this is required, otherwise you will get null pointer exception
        for (int i=1; i<=login.userNames.size(); i++) {
            extentLogger = report.createTest("Login as a Event Scrum Manager #" + i);
            BriteErpUtilsOST.login(login.userNames.get(i-1), login.password);
            SeleniumUtils.waitPlease(3);
            String expectedTitle="#Inbox - Odoo";
            String actualTitle=Driver.getDriver().getTitle();
            extentLogger.info("Actual title is :"+actualTitle);

            Assert.assertTrue(expectedTitle.contains(actualTitle));
            BriteErpUtilsOST.logout();
            extentLogger.pass("It has been verified that Main Page title is \""+expectedTitle+"\".");
        }

    }



}