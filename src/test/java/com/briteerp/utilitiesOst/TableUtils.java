package com.briteerp.utilitiesOst;

import com.briteerp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TableUtils {


    /**
     * Write a method that will return count of rows
     *
     */
    public int getCountOfRows(){
        return Driver.getDriver().findElements(By.cssSelector("#table1 tr")).size();
    }

    /**
     * Write a method that will return count of rows
     * In this case, object of by allows us to specify table locator of any type
     */
    public int getCountOfRows(By by){
        return Driver.getDriver().findElements(by).size();
    }

    @Test
    public void countOfRowsTest1(){
        Assert.assertEquals(getCountOfRows(), 5, "Number of rows doesn't match");
    }

    @Test
    public void countOfRowsTest2(){
        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")), 5, "Number of rows doesn't match");
    }

    /**
     *  Write a method that returns number of columns
     */
    public int getCountOfColumns(){
        return Driver.getDriver().findElements(By.cssSelector("#table1 th")).size();
    }

    /**
     *  Write a method that returns number of columns
     */
    public int getCountOfColumns(By by){
        return Driver.getDriver().findElements(by).size();
    }

    @Test
    public void countOfColumnsTest1(){
        Assert.assertEquals(getCountOfColumns(), 6, "Number of columns doesn't match");
    }

    @Test
    public void countOfColumnsTest2(){
        Assert.assertEquals(getCountOfColumns(By.xpath("//table[1]//th")), 6, "Number of columns doesn't match");
    }
    /**
     * Let's write a method tha twill return table size
     * first value - number of rows
     * second value - number of columns
     */
    public int[] getTableSize(){
        int[] size = {getCountOfRows(), getCountOfColumns()};
        return size;
    }


    /**
     * Let's write a method tha twill return table size
     * first value - number of rows
     * second value - number of columns
     * by - represents locator for table
     */
    public int[] getTableSize(By rowLocator, By columnLocator){
        int[] size = {getCountOfRows(rowLocator), getCountOfColumns(columnLocator)};
        return size;
    }

    @Test
    public void tableSizeTest1(){
        int[] expectedSize = {5, 6};
        int[] actualSize = getTableSize();
        Assert.assertEquals(actualSize, expectedSize, "Table size doesn't match");
    }

    @Test
    public void tableSizeTest2(){
        int[] expectedSize = {5, 6};
        int[] actualSize = getTableSize(By.xpath("//table[1]//tr"), By.xpath("//table[1]//th"));
        Assert.assertEquals(actualSize, expectedSize, "Table size doesn't match");
    }

    /**
     * Let's write a method that will return table headers (column names) as a list of webelements.
     */
    public List<WebElement> getHeaders(){
        return Driver.getDriver().findElements(By.cssSelector("#table1 th"));
    }

    /**
     *
     * This method returns table headers (column names) text as a List of Strings
     * @return
     */
    public List<String> getHeadersText(){
        List<String> headers  = new ArrayList<>();
        for(WebElement tableHeader: getHeaders()){
            headers.add(tableHeader.getText());
        }
        return headers;
    }

    @Test
    public void getHeadersTest(){
        List<String> expectedColumnNames = Arrays.asList("Last Name ", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(getHeadersText(), expectedColumnNames, "Column names don't match!");
    }

    //Let's write a test
    //to verify if first name column is sorted in alphabetic order
    @Test
    public void sortColumnTest(){
        String columnName = "First Name";
        Driver.getDriver().findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();
        //create list to compare
        List<String> sorted = new ArrayList<>();
        //add everything to the list
        sorted.addAll(getColumnData(columnName));
        //sort it with Collections.sort()
        Collections.sort(sorted);
        //Compare if sorted list is the same as before sorting
        Assert.assertEquals(getColumnData(columnName), sorted);
    }

    public List<String> getColumnData(String columnName){
        int columnNumber = 0;
        for (int i=0; i < getCountOfColumns(); i++){
            if(columnName.equals(getHeadersText().get(i))){
                columnNumber = i + 1;
            }
        }
        String locatorForColumn = "//table[1]//tbody//tr//td["+columnNumber+"]";
        //this is a collection of web elements that contains values from specific column
        List<WebElement> columnCollectionOfWebElements = Driver.getDriver().findElements(By.xpath(locatorForColumn));
        List<String> columnCollectionOfText = new ArrayList<>();
        for (WebElement element: columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());
        }
        return columnCollectionOfText;
    }


}