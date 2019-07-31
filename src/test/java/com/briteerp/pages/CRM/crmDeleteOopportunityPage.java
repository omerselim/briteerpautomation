package com.briteerp.pages.CRM;

import org.openqa.selenium.WebDriver;

public class crmDeleteOopportunityPage {

//    private WebDriver driver = Driver.getDriver();
//    public String createCalendarEventBtnLocator  = "a[title^='Create Calendar']";
//    public String repeatCheckBoxLocator = "input[id^='recurrence-repeat-view']";
//    public String repeatsDropdownLocator = "select[id^='recurrence-repeats-view']";
    WebDriver driver;

    String usernameLocator ="login";
    String passwordLocator ="password";
    String loginLocator = "button[type='submit']";
    String CRMTabLocator = "//*[id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[5]";
    String ListButtonLocator ="button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String pipelineLocator="/html/body/div[1]/div[2]/div[1]/ol/li";
    String beforeDeleteLocator = "span[class='o_pager_limit']";
    String vendorBottonLocator="//tr[1]//td[1]";
    String ActionButtonLocator="//button[contains(text(),'Action')]";
    String DeleteButtonLocator="//a[contains(text(),'Delete')]";
    String okButtonLocator ="//span[contains(text(),'Ok')]";
    String afterDeleteNumberLocator = "//span[@class='o_pager_limit']";



//    //    let's write a method that would return collection of repeat options
//    public List<String> getRepeatOptions(){
//        //we crated select object to work with dropdown
//        Select select = new Select(driver.findElement(By.cssSelector(repeatsDropdownLocator)));
//        //.getOptions(); return all available options in the dropdown.
//        //every option is a webelement
//        List<WebElement> options = select.getOptions();
//        //this is a collection that will store text of every option
//        List<String> optionsTextList = new ArrayList<>();
//        for(WebElement option: options){
//            //go through every option and retrieve text
//            //add that text into collection of text options
//            optionsTextList.add(option.getText());
//        }
//        return  optionsTextList;
//    }




}
