package com.briteerp.pages.crm;

import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

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

    @FindBy(xpath="//a[contains(text(),'Search More...')]")
    public WebElement SearchMoreElement ;

    @FindBy(css= "tbody[class='ui-sortable']")
    public static WebElement CustomerTable ;

    @FindBy(xpath="(//li[@class='ui-menu-item'])[1]")
    public WebElement CustomerChoiceTableElement ;

    @FindBy(xpath= "(//span[contains(text(),'Create')])[3]")
    public WebElement CreateCustomerElement ;

    @FindBy(css="input[name='planned_revenue']")
    public WebElement ExpectedRevenueElement ;

    @FindBy(css="table[class='o_group o_inner_group o_group_col_6'] div[name='priority'] a[title='Low']")
    public WebElement OneStarElement ;

    @FindBy(xpath="//table[@class='o_group o_inner_group o_group_col_6']//div[@name='priority']//a[@title='High']")
    public WebElement TwoStarElement ;

    @FindBy(xpath="//table[@class='o_group o_inner_group o_group_col_6']//div[@name='priority']//a[@title='Very High']")
    public WebElement ThreeStarElement ;

    @FindBy(xpath="Priority")
    public WebElement priorityElement ;

    @FindBy(css="button[name='close_dialog']")
    public WebElement CreateFinalElement ;

    public String qqqq;


    public OpportunityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//----------------------------------------------------------------------------------------------------------

    public static void createOpportunity(int NamOfNewOpportunities, int maxNumberOfLatter ,int maxDigit) {

        for (int i=0; i < NamOfNewOpportunities; i++) {

            String firstName=OpportunityPage.randomFirstName(maxNumberOfLatter);
            String lastName=OpportunityPage.randomLastName(maxNumberOfLatter);
            String Title=firstName + " " + lastName;
            String Revenue=OpportunityPage.randomRevenue(maxDigit);
            OpportunityPage opportunity=new OpportunityPage();
            SeleniumUtils.waitPlease(1);
            opportunity.CreateElement.click();
//            SeleniumUtils.waitPlease(2);
            opportunity.OpportunityTitle.sendKeys(Title);
//            SeleniumUtils.waitPlease(1);
            opportunity.CustomerElement.click();
//            SeleniumUtils.waitPlease(1);
            opportunity.SearchMoreElement.click();
//            SeleniumUtils.waitPlease(1);
//            System.out.println(BriteErpUtilsOST.getCountOfRows(By.cssSelector("tbody[class='ui-sortable']>tr")));
            opportunity.clickRandomCustomer();

//            opportunity.CustomerChoiceElement.click();
            opportunity.ExpectedRevenueElement.click();
            opportunity.ExpectedRevenueElement.clear();
            opportunity.ExpectedRevenueElement.sendKeys(Revenue);
 //           SeleniumUtils.waitPlease(1);
            opportunity.clickStar();
 //           SeleniumUtils.waitPlease(1);
            opportunity.CreateFinalElement.click();
            SeleniumUtils.waitPlease(1);
        }
    }

    public static String randomFirstName(int maxNumberOfLatter){
        Random rand = new Random();
        String choices2 = "abcdefghijklmnopqrstuvwxyz" ;
        String choices1 = choices2.toUpperCase();
        int i = 0;
        String name = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        while ( i<SeleniumUtils.randomInt(maxNumberOfLatter)) {

            name = name + choices2.charAt( rand.nextInt( choices2.length() ) );
            i= i + 1;
        }
        return name;
    }

    public static String randomLastName(int maxNumberOfLatter) {
        Random rand = new Random();
        String choices2 = "abcdefghijklmnopqrstuvwxyz" ;
        String choices1 = choices2.toUpperCase();
        int i = 0;
        String name = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        while ( i<SeleniumUtils.randomInt(maxNumberOfLatter) ) {

            name = name + choices2.charAt( rand.nextInt( choices2.length() ) );
            i= i + 1;
        }
        return name;
    }
    // numberes before point  x x x . __  whole number  parts
    public static String randomRevenue(int maxDigit) {
        Random rand = new Random();
        String choices1 = "123456789" ;
        String choices2= "1234567890" ;

        String number1 = choices1.charAt( rand.nextInt( choices1.length()))+ "";
        for (int i=1;  i<SeleniumUtils.randomInt(maxDigit); i++) {
            number1 = number1 + choices2.charAt( rand.nextInt( choices2.length() ) );
        }

// decimal parts
        String number2="";
        for (int i=0; i<2; i++ ) {
            number2 = number2+ choices2.charAt( rand.nextInt( choices2.length() ) );
        }
        String number = number1+"."+number2;
        return number;
    }

    public static double randomDecimal(int max) {
        Random rand = new Random();
        return max*(rand.nextDouble());
    }




    public void clickRandomCustomer() {
        OpportunityPage opportunity=new OpportunityPage();
        int size =BriteErpUtilsOST.getCountOfRows(By.cssSelector("tbody[class='ui-sortable']>tr")); // table[id='table1'] > tbody>tr
        int random=SeleniumUtils.randomInt(size);
        Driver.getDriver().findElement(By.cssSelector("tbody[class='ui-sortable'] tr:nth-of-type(" + random + ")")).click();
//        Driver.getDriver().findElement(By.xpath("//li[@class='ui-menu-item'])["+random+"]")).click();

    }

    public void clickStar() {
        OpportunityPage opportunity=new OpportunityPage();
        int n = SeleniumUtils.randomInt(3);
        switch (n){
           case 1:
               opportunity.OneStarElement.click();
               break;
           case 2:
               opportunity.TwoStarElement.click();
               break;
           case 3:
               opportunity.ThreeStarElement.click();
               break;
           default:
               break;
         }


    }











}
