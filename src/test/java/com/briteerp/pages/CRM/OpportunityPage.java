package com.briteerp.pages.CRM;

import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpportunityPage {
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));


    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement pivotElement;

    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public WebElement listElement;

    @FindBy(xpath= "(//span[@class='fa fa-ellipsis-v'])[1]")
    public WebElement optToggleElement;

    @FindBy(xpath= "(//div[@class='oe_kanban_content'])[1]")
    public WebElement FirstOptElement;

    @FindBy(xpath="(//a[contains(text(),'Delete')])[2]")
    public WebElement DeleteButton1Locator;

    @FindBy(css="[class='btn btn-sm btn-primary']")
    public WebElement okButton1Locator;

    @FindBy(xpath= "//li[contains(text(),'Pipeline')]")
    public WebElement pipelineLocator;

    @FindBy(css= "span[class='o_pager_limit']")  //     span[class='o_pager_limit']
    public WebElement optNumberBeforeDelete;

    @FindBy(xpath="//tr[1]//td[1]")
    public WebElement vendorBottonLocator;

    @FindBy(css="tr:nth-of-type(1)>td:nth-of-type(1)>div:nth-of-type(1)>input:nth-of-type(1)")
    public WebElement checkBoxLocator;

    @FindBy(xpath="//button[contains(text(),'Action')]")
    public WebElement ActionButtonLocator;

    @FindBy(linkText="Delete")
    public WebElement DeleteButton2Locator;

    @FindBy(xpath="//span[contains(text(),'Ok')]")
    public WebElement okButton2Locator ;

    @FindBy(css= "span[class='o_pager_limit']")
    public WebElement optNumberAfterDelete ;

    @FindBy(css= "button[class^='btn btn-primary btn-sm o-kanban']")
    public WebElement CreateElement ;

    @FindBy(css= "input[class^='o_field_char o_field_widget o_input o_required']")
    public WebElement OpportunityTitle ;

    @FindBy(xpath="(//div[@class='o_input_dropdown'])[1]")
    public WebElement CustomerElement ;

    @FindBy(xpath="(//li[@class='ui-menu-item'])[1]")
    public WebElement CustomerChoiceElement ;

    @FindBy(css="[class='o_field_float o_field_number o_field_widget o_input']")
    public WebElement ExpectedRevenueElement ;

    @FindBy(xpath="//table[@class='o_group o_inner_group o_group_col_6']//div[@name='priority']//a[@title='Very High']")
    public WebElement TwoStarElement ;

    @FindBy(xpath="Priority")
    public WebElement priorityElement ;

    @FindBy(css="button[name='close_dialog']")
    public WebElement CreateFinalElement ;


    public OpportunityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static void createOpportunity(String Title, String Revenue ) {
        OpportunityPage opportunity = new OpportunityPage();
        SeleniumUtils.waitPlease(1);
        opportunity.CreateElement.click();
        SeleniumUtils.waitPlease(1);
        opportunity.OpportunityTitle.sendKeys(Title);
        SeleniumUtils.waitPlease(1);
        opportunity.CustomerElement.click();
        opportunity.CustomerChoiceElement.click();
        opportunity.ExpectedRevenueElement.click();
        opportunity.ExpectedRevenueElement.clear();
        opportunity.ExpectedRevenueElement.sendKeys(Revenue);
        SeleniumUtils.waitPlease(1);
        opportunity.TwoStarElement.click();
        SeleniumUtils.waitPlease(1);
        opportunity.CreateFinalElement.click();


    }





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
