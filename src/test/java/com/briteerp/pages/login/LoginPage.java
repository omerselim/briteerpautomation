package com.briteerp.pages.login;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage {



    private WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));

    @FindBy(id="login")
    public WebElement userNameElement;

    @FindBy(id="password")
    public WebElement passwordElement;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButtonElement;

    @FindBy(className="custom-checkbox__icon")
    public WebElement rememberMeElement;

    @FindBy(xpath="//title[contains(text(),'#Inbox - Odoo')]")
    public WebElement titleElement;

    @FindBy(className="oe_topbar_name")
    public WebElement ManagerLocator;

    @FindBy(css="a[data-menu='logout']")
    public WebElement logOutLocator;

    public List<String> userNames=new ArrayList<String>(Arrays.asList("eventscrmmanager28@info.com",
            "eventscrmmanager29@info.com", "eventscrmmanager30@info.com", "eventscrmmanager31@info.com",
            "eventscrmmanager32@info.com", "eventscrmmanager33@info.com", "eventscrmmanager34@info.co m"));

    public String password="eventscrmmanager";

    public LoginPage() {PageFactory.initElements(Driver.getDriver(), this); }


    public void login() {
        LoginPage login=new LoginPage();
        login.userNameElement.sendKeys(ConfigurationReader.getProperty("username"));
        login.passwordElement.sendKeys(ConfigurationReader.getProperty("password"));
        login.loginButtonElement.click();
    }

    public void login(String username, String password) {
        LoginPage login=new LoginPage();
        login.userNameElement.sendKeys(username);
        login.passwordElement.sendKeys(password);
        login.loginButtonElement.click();
    }

    public void logout() {
        LoginPage logout=new LoginPage();
        logout.ManagerLocator.click();
        logout.logOutLocator.click();

    }
}
