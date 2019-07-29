package com.briteerp.utilitiesOst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Generic01 {
    private WebDriver driver;

    // constructor

    public Generic01(WebDriver driverr) {
        driver = driverr;
    }

    // method to find an element
    public WebElement getElement(String locator, String type) throws Exception {

        List<WebElement> elem = new ArrayList<>();
        WebElement element = null;
        type = type.toLowerCase().replace(" ", "");


        try {
            if(type.equals("id")){
                element = driver.findElement(By.id(locator));
            }else if(type.equals("xpath")){
                element = driver.findElement(By.xpath(locator));
            }else if(type.equals("name")) {
                element = driver.findElement(By.name(locator));
            }else if(type.equals("linktext")) {
                element = driver.findElement(By.linkText(locator));
            }else if(type.equals("partiallinktext")) {
                element = driver.findElement(By.partialLinkText(locator));
            }else if(type.equals("classname")) {
                element = driver.findElement(By.className(locator));
            }else if(type.equals("css")) {
                element = driver.findElement(By.cssSelector(locator));

            }else if(type.equals("tagname")) {
                element = driver.findElement(By.tagName(locator));

            }else{
                System.out.println("Locator type is not supported.");
            }

        }catch (Exception e){
            System.out.println("error occurred: \n------------\n" + e.getMessage());

        }


        elem.add(element);
        if(elem.isEmpty()){
            System.out.println("Element not found with " + type + ": \"" + locator + "\"");
        }else{
            System.out.println("Element found with " + type + ": \"" + locator + "\"");
        }

        return element;

    }

    // method to find list of elements
    public  List<WebElement> getElementList(String locator, String type){

        List <WebElement> element = new ArrayList<>();
        type = type.toLowerCase().replace(" ", "");

        if(type.equals("id")){
            element = driver.findElements(By.id(locator));
        }else if(type.equals("xpath")){
            element = driver.findElements(By.xpath(locator));
        }else if(type.equals("name")) {
            element = driver.findElements(By.name(locator));
        }else if(type.equals("linktext")) {
            element = driver.findElements(By.linkText(locator));
        }else if(type.equals("partiallinktext")) {
            element =  driver.findElements(By.partialLinkText(locator));
        }else if(type.equals("classname")) {
            element = driver.findElements(By.className(locator));
        }else if(type.equals("css")) {
            element = driver.findElements(By.cssSelector(locator));
        }else if(type.equals("tagname")) {
            element = driver.findElements(By.tagName(locator));
        }else{
            System.out.println("Locator type is not supported.");

        }


        if(element.isEmpty()){
            System.out.println("Element not found with " + type + ": " + locator);
        }else{
            System.out.println("Element found with " + type + ": " + locator);
        }

        return element;

    }

    // method to check if an element is present
    public void isPresent(String locator, String type){

        List<WebElement> list = getElementList(locator, type);

        int size = list.size();
        if (size > 0) {
            System.out.println("Element is present");
        }else{
            System.out.println("Element is not present");
        }

    }

    public  void sleep(int seconds) throws InterruptedException {
        Thread.sleep(1000 * seconds);
    }




}