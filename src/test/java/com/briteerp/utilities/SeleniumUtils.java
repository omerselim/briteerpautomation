package com.briteerp.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumUtils {



    /**
     *
     * @param page
     * @param driver
     * This method will open example page based on link name
     */
    public static void openPage(String page, WebDriver driver){
        //we will find all examples on the home page
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for(WebElement example: listOfExamples){
            if(example.getText().contains(page)){
                example.click();
                break;
            }
        }
    }


    /*
     * switches to new window by the exact title
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
    /**
     * return a list of string from a list of elements
     * text
     *
     * @param list of webelements
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }




    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }
    /**
     * Highlighs an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }
//============================================================================================
//    Verify
//--------------------------------------------------------------------------------------------
    /**
     *
     * @param expectedResult
     * @param actualResult
     * Verifies if two strings are equals.
     */
    public static void verifyEquals(String expectedResult, String actualResult){
        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: "+expectedResult);
            System.out.println("Actual result: "+actualResult);
        }
    }

//--------------------------------------------------------------------------------------------

    public static void verifyIsDisplayed(WebElement element){
        if(element.isDisplayed()){
            System.out.println("PASSED");
            System.out.println(element.getText()+": is visible");
        }else{
            System.out.println("FAILED");
            System.out.println(element.getText()+": is not visible!");
        }
    }

//--------------------------------------------------------------------------------------------
    /**
     * Verifies whether the element matching the provided locator is displayed on page
     *
     * @param by
     * @throws AssertionError if the element matching the provided locator is not found or not displayed
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }


//--------------------------------------------------------------------------------------------
    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     *
     * @param by
     * @throws AssertionError the element matching the provided locator is displayed
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse(Driver.getDriver().findElement(by).isDisplayed(), "Element should not be visible: " + by);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

//--------------------------------------------------------------------------------------------
    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }



//============================================================================================
//    Explicit Wait
//--------------------------------------------------------------------------------------------

    /**
     *  This method will put on pause execution
     * @param seconds
     */
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//--------------------------------------------------------------------------------------------

    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     * @param driver
     * @param by
     * @param attempts
     */
    public static void clickWithWait(WebDriver driver, By by, int attempts){
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while(counter < attempts) {
            try {
                //selenium must look for element again
                driver.findElement(by).click();
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                System.out.println(e);
                //print attempt
                System.out.println("Attempt :: " + ++counter);
                //wait for 1 second, and try to click again
                waitPlease(1);
            }
        }
    }


//--------------------------------------------------------------------------------------------
    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

//--------------------------------------------------------------------------------------------

    /**
     * Waits for element matching the locator to be visible on the page
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//--------------------------------------------------------------------------------------------

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

//--------------------------------------------------------------------------------------------

    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),  Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

//--------------------------------------------------------------------------------------------
    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

//--------------------------------------------------------------------------------------------
    /**
     * Waits for element to be not stale
     * @param element
     */
    public void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

//--------------------------------------------------------------------------------------------
     /**
     * attempts to click on provided element until given time runs out
     * @param element
     * @param timeout
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

//============================================================================================
//    JavaScript
//--------------------------------------------------------------------------------------------
    /**
     * Clicks on an element using JavaScript
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
//--------------------------------------------------------------------------------------------
    /**
     * Scrolls down to an element using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

//--------------------------------------------------------------------------------------------
    /**
     * executes the given JavaScript command on given web element
     * @param element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

//--------------------------------------------------------------------------------------------
    /**
     * executes the given JavaScript command on given web element
      * @param command
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }


//============================================================================================
//    Random
//--------------------------------------------------------------------------------------------

    public static String randomName(int NumOfFnameCharcters) {
        Random rand = new Random();
        String choices2 = "abcdefghijklmnopqrstuvwxyz" ;
        String choices1 = choices2.toUpperCase();
        int i = 0;
        String name = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        while ( i<NumOfFnameCharcters ) {

            name = name + choices2.charAt( rand.nextInt( choices2.length() ) );
            i= i + 1;
        }
        return name;
    }

//--------------------------------------------------------------------------------------------

    public static String randomLastName(int NumOfLnameCharcters) {
        Random rand = new Random();
        String choices2 = "abcdefghijklmnopqrstuvwxyz" ;
        String choices1 = choices2.toUpperCase();
        int i = 0;
        String name = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        while ( i<NumOfLnameCharcters -1) {

            name = name + choices2.charAt( rand.nextInt( choices2.length() ) );
            i= i + 1;
        }
        return name;
    }

//------------------------------------------------------------------------------------------
// numberes before point  x x x . _ _  whole parts

    public static String randomNumber(int numberOfDigit) {
        Random rand = new Random();
        String choices1 = "123456789" ;
        String choices2= "1234567890" ;

        String number1 = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        for (int i=0;  i<numberOfDigit-1; i++) {
            number1 = number1 + choices2.charAt( rand.nextInt( choices2.length() ) );
        }


// decimal parts _ _ _ . x x

        String number2="";
        for (int i=0; i<2; i++ ) {
            number2 = number2+ choices2.charAt( rand.nextInt( choices2.length() ) );
        }
        String number = number1+"."+number2;
        return number;
    }

//------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------
    public static int randomInt(int max) {
        Random rand = new Random();
        return (rand.nextInt(max) + 1);
    }

    public static double randomDecimal(int max) {
        Random rand = new Random();
        return max*(rand.nextDouble());
    }



//============================================================================================
//    ScreenShoot
//--------------------------------------------------------------------------------------------

    /**
     * This method will take a screenshot
     * @param name
     * @return
     */
    public static String getScreenshot(String name)  {
        // name the screenshot with the current date time to avoid duplicate name
//        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hh:mm:ss a"));
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"));
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";

        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }
//-------------------------------------------------------------------------------------------------
    /**
     * This method will take a screenshot
     * @param name
     * @return
     */
    public static String getScreenshot2(String name)  {
        // name the screenshot with the current date time to avoid duplicate name
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd_hhmmss"));
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name+"_"+ dateTime + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }







//============================================================================================
//
//--------------------------------------------------------------------------------------------
}