/*
CA -01  : Abble to acces calendar and navigate arrows and day-week-month tabs.

Step-01	open URL	http://54.148.96.210/web/login
        Should be able to access BriteERP log in page.
Step-02	Click and Enter valid email adress to the Email-Box	in3@info.com
        Should be able to Click and Enter valid email adress to the Email Box
Step-03	Click and Enter valid password to the Password-Box	alsfuh7we72
        Should be able to Click and Enter valid password to the Password-Box
Step-04	Click Log in box to enter to the main page
        Should be able to Click Log in box to enter to the main page
Step-05	Click Calendar to open calendar page
        Should be able to see Calendar page
Step-06	Click left arrow
        Should be able to move Calendar to a week back from main week
Step-07	Click right arrow two times
        Should be able to move Calendar a following week from main week
Step-08	Click Day tab
        Should be able to see day vision on Calendar
Step-09	Click Week tab
        Should be able to see week vision on Calendar
Step-10	Click Month tab
        Should be able to see month vision on Calendar

 */
package com.briteerp.tests.components.calendar;
import com.briteerp.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Briteerp_CA01 {

    WebDriver driver;
    String usernameLocator = "input[name='login']";
    String passwordLocator = "input[name='password']";
    String loginLocator         = "*[type='submit']";
    String calendarLocator      = "(//span[contains(text(),'Calendar')])[1]";
    String leftArrowLocator     = "span[class='fa fa-arrow-left']";
    String firstDayLocator      = "//th[@class='fc-day-header fc-widget-header fc-sun']";
    String tabDayLocator        = "button[class='o_calendar_button_day btn btn-sm btn-default']";
    String tabWeekLocator       = "button[class='o_calendar_button_week btn btn-sm btn-default']";
    String tabMonthLocator      = "button[class='o_calendar_button_month btn btn-sm btn-default']";
    String rightArrowLocator    = "span[class='fa fa-arrow-right']";
    String TodayLocator        = "button[class='o_calendar_button_today btn btn-sm btn-primary']";
    String ManagerLocator       = "oe_topbar_name";
    String logOutLocator        = "a[data-menu='logout']";


/*
Step-01	open URL	http://54.148.96.210/web/login
        Should be able to access BriteERP log in page.
*/
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://54.148.96.210/web/login");
    }


/*
Step-02	Click and Enter valid email adress to the Email-Box	in3@info.com
        Should be able to Click and Enter valid email adress to the Email Box
Step-03	Click and Enter valid password to the Password-Box	alsfuh7we72
        Should be able to Click and Enter valid password to the Password-Box
Step-04	Click Log in box to enter to the main page
        Should be able to Click Log in box to enter to the main page
*/
    @BeforeMethod
    public void login(){
        driver.findElement(By.cssSelector(usernameLocator)).sendKeys("in3@info.com");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("alsfuh7we72");
        driver.findElement(By.cssSelector(loginLocator)).click();
        SeleniumUtils.waitPlease(2);
        System.out.println("===================================================");
    }


/*
Step-05	Click Calendar to open calendar page
        Should be able to see Calendar page
*/
    @Test(priority = 1)
    public void OpenCalendar() {
        System.out.println("Test1 performing : Open Calendar");
        System.out.println("-------------------------------------------------");
        driver.findElement(By.xpath(calendarLocator)).click();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(driver.getTitle(), "Meetings - Odoo");
        System.out.println("Successful");
    }


/*
Step-06	Click left arrow
        Should be able to move Calendar to a week back from main week
Step-07	Click right arrow two times
        Should be able to move Calendar a following week from main week
*/
    @Test(priority = 2)
    public void ArrowFunctionality() {
        System.out.println("Test2 performing : ArrowFunctionality");
        System.out.println("-------------------------------------------------");
        driver.findElement(By.xpath(calendarLocator)).click();
        SeleniumUtils.waitPlease(3);
        String testingDay = driver.findElement(By.xpath(firstDayLocator)).getAttribute("data-date");
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector(leftArrowLocator)).click();
        SeleniumUtils.waitPlease(3);
        String BeforeTestingDay = driver.findElement(By.xpath(firstDayLocator)).getAttribute("data-date");
        Assert.assertFalse(testingDay.equalsIgnoreCase(BeforeTestingDay));

        driver.findElement(By.cssSelector(rightArrowLocator)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector(rightArrowLocator)).click();
        SeleniumUtils.waitPlease(3);
        String AfterTestingDay = driver.findElement(By.xpath(firstDayLocator)).getAttribute("data-date");
        SeleniumUtils.waitPlease(3);

        driver.findElement(By.cssSelector(TodayLocator)).click();
        SeleniumUtils.waitPlease(3);
        String BackTestingDay = driver.findElement(By.xpath(firstDayLocator)).getAttribute("data-date");
        SeleniumUtils.waitPlease(3);

        Assert.assertEquals(BackTestingDay, testingDay);
        System.out.println("A week before the Testing day \t:"+BeforeTestingDay);
        System.out.println("Testing day \t\t\t\t\t:"+testingDay);
        System.out.println("A week after the Testing day \t:"+AfterTestingDay);
        System.out.println("Successful");
    }


/*
Step-08	Click Day tab
        Should be able to see day vision on Calendar
Step-09	Click Week tab
        Should be able to see week vision on Calendar
Step-10	Click Month tab
        Should be able to see month vision on Calendar
*/
    @Test(priority = 3)
    public void DayWeekMonthTabsVerifications() {
        System.out.println("Test3 performing : Day-Week-Month Tabs Verifications");
        System.out.println("-------------------------------------------------");
        driver.findElement(By.xpath(calendarLocator)).click();
        SeleniumUtils.waitPlease(3);
        WebElement day = driver.findElement(By.cssSelector(tabDayLocator));
        day.click();
        Assert.assertEquals(day.getText(),"Day");
        SeleniumUtils.waitPlease(3);

        WebElement week = driver.findElement(By.cssSelector(tabWeekLocator));
        week.click();
        Assert.assertEquals(week.getText(),"Week");
        SeleniumUtils.waitPlease(3);


        WebElement month = driver.findElement(By.cssSelector(tabMonthLocator));
        month.click();
        Assert.assertEquals(month.getText(),"Month");
        SeleniumUtils.waitPlease(3);
        System.out.println("Successful");


/*

//        String Day = driver.findElement(By.className(dayDayLocator)).getText();
//
//        driver.findElement(By.cssSelector(rightArrowLocator)).click();
//        SeleniumUtils.waitPlease(2);
//        String NextDay = driver.findElement(By.className(dayDayLocator)).getText();
//
//        driver.findElement(By.cssSelector(leftArrowLocator)).click();
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.cssSelector(leftArrowLocator)).click();
//        String BeforeDay = driver.findElement(By.className(dayDayLocator)).getText();
//
//        System.out.println("BeforeDay :"+BeforeDay+" - Day :"+Day+" - NexteDay :"+NextDay);

*/

    }

    @AfterMethod
    public void logout() {
        driver.findElement(By.className(ManagerLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(logOutLocator)).click();
        SeleniumUtils.waitPlease(2);
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }


}
