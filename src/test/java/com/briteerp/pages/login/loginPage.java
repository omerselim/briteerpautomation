package com.briteerp.pages.login;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));

    @FindBy(id = "login")
    public WebElement userNameElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButtonElement;

    @FindBy(className = "custom-checkbox__icon")
    public WebElement rememberMeElement;

    @FindBy(className = "oe_topbar_name")
    public WebElement ManagerLocator;

    @FindBy(css = "a[data-menu='logout']")
    public WebElement logOutLocator;

    public loginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static void login(){
        loginPage login = new loginPage();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        login.userNameElement.sendKeys(username);
        login.passwordElement.sendKeys(password);
        login.loginButtonElement.click();
    }

    public static void logout() {
        loginPage logout = new loginPage();
        logout.ManagerLocator.click();
        logout.logOutLocator.click();
        SeleniumUtils.waitPlease(2);
    }
}
