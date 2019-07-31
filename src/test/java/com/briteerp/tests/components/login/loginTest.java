package com.briteerp.tests.components.login;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends TestBase {

    @Test
    public void UserCredential() {
        SeleniumUtils.waitPlease(2);
        String expectedTitle = "#Inbox - Odoo";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}