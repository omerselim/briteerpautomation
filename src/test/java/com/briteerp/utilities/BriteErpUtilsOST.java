package com.briteerp.utilities;

import com.briteerp.tests.pages.login.loginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
     * Write a method that will return count of rows
     *
     */
    public static int getCountOfRows(){
        return Driver.getDriver().findElements(By.cssSelector("tbody tr")).size();
    }

    /**
     * Write a method that will return count of rows
     * In this case, object of by allows us to specify table locator of any type
     */
    public static int getCountOfRows(By by){
        return Driver.getDriver().findElements(by).size();
    }

    /**
     *  Write a method that returns number of columns
     */
    public static int getCountOfColumns(){
        return Driver.getDriver().findElements(By.cssSelector("table td")).size();
    }

    /**
     *  Write a method that returns number of columns
     */
    public static int getCountOfColumns(By by){
        return Driver.getDriver().findElements(by).size();
    }

// Need adaptation and modification for BriteERP
//    public static List<String> getColumnData(String columnName){
//        int columnNumber = 0;
//        for (int i=0; i < getCountOfColumns(); i++){
//            if(columnName.equals(getHeadersText().get(i))){
//                columnNumber = i + 1;
//            }
//        }
//        String locatorForColumn = "//table[1]//tbody//tr//td["+columnNumber+"]";
//        //this is a collection of web elements that contains values from specific column
//        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(By.xpath(locatorForColumn));
//        List<String> columnCollectionOfText = new ArrayList<>();
//        for (WebElement element: columnCollectionOfWebElements){
//            columnCollectionOfText.add(element.getText());
//        }
//        return columnCollectionOfText;
//    }

    public static List<String> getColumnData(int columnNumber){
        String locatorForColumn = "tbody>tr>td:nth-of-type("+columnNumber+")";
        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(By.cssSelector(locatorForColumn));
        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element: columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;
    }

    public static List<String> getColumnData(By by){
        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(by);
        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element: columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;
    }

    public static double getSumOfColumn(int columnNumber){
        String locatorForColumn = "tbody>tr>td:nth-of-type("+columnNumber+")";
        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(By.xpath(locatorForColumn));

        double sum = 0;
        for (WebElement element: columnCollectionOfWebElements){
            String s = element.getText().replace(",","").replace(".","");
            sum += Integer.parseInt(s);
                }
        return sum/100;
    }

    public static double getSumOfColumn(By by){
        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(by);

        double sum = 0;
        for (WebElement element: columnCollectionOfWebElements){
            String s = element.getText().replace(",","").replace(".","");
            sum += Integer.parseInt(s);
        }
        return sum/100;
    }

    public static double convertToDouble(String s){
        s = s.replace(",","").replace(".","");
        double d =Integer.parseInt(s);
        return d/100;
    }
    public static void takesScreenshoot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
        File source=ts.getScreenshotAs(OutputType.FILE);
        String dest="C:\\Users\\ostur\\IdeaProjects\\briteerpautomation\\screenshoots\\";
        File destination=new File(dest);
        FileUtils.copyFile(source, destination);
        System.out.println("screenshot is taken...");
    }


//????????????????????????????????????????????????????????????????????????????????????????????
//    loaderMaskLocator  / need adaptation and modification for BriteERP
//??????????????????????????????????????????????????????????????????????????????????????????????
//    /**
//     * Waits until loader screen present. If loader screen will not pop up at all,
//     * NoSuchElementException will be handled  bu try/catch block
//     * Thus, we can continue in any case.
//     */
//    public static void waitUntilLoaderScreenDisappear() {
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));
//
//            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
//        }catch (Exception e){
//            System.out.println(e+" :: Loader mask doesn't present.");
//        }
//    }
//??????????????????????????????????????????????????????????????????????????????????????????????????????????????????




}
