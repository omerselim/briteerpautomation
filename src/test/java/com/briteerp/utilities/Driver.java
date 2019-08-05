package com.briteerp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
    private static WebDriver driver;


    private Driver(){

    }

    public static WebDriver getDriver(){
        if(driver==null){
           String browser = ConfigurationReader.getProperty("browser");
           switch (browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
                   break;
                   default:
                       throw new RuntimeException("Illegal browser name!");
               case "chrome-headless":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                   break;
               case "firefox-headless":
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                   break;

               case "ie":
                   if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                       throw new WebDriverException("Your operating system does not support the requested browser");
                   }
                   WebDriverManager.iedriver().setup();
                   driver = new InternetExplorerDriver();
                   break;

//               case "edge":
//                   if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//                       throw new WebDriverException("Your operating system does not support the requested browser");
//                   }
//                   WebDriverManager.edgedriver().setup();
//                   driver = new EdgeDriver();
//                   break;
//
//               case "safari":
//                   if (System.getProperty("os.name").toLowerCase().contains("windows")) {
//                       throw new WebDriverException("Your operating system does not support the requested browser");
//                   }
//                   WebDriverManager.getInstance(SafariDriver.class).setup();
//                   driver = new SafariDriver();
//                   break;
           }
        }
        return driver;
    }

    //will kill driver
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
