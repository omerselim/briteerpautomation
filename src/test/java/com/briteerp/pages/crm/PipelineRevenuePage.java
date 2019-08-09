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

public class PipelineRevenuePage {
    public static int nthRowOfTable;

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));

    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement pivotElement;

    @FindBy(xpath= "//tr[1]//td[2]")
    public WebElement PivotTotalExpectedRevenueElement;

    @FindBy(css= "tr:nth-child(4) > td:nth-child(2)")
    public WebElement PivotSecondExpectedRevenueElement;

    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public WebElement listElement;

    @FindBy(css="thead th.o_column_sortable:nth-child(3)")
    public WebElement headCustomerElement;

    @FindBy(css= "tr:nth-child(2) > td:nth-child(9)")
    public WebElement ListSecondExpectedRevenueElement;

    @FindBy(css= "td[title='Expected Revenues']")
    public WebElement ListExpectedRevenueElement;

    @FindBy(css= "td[class='o_pivot_header_cell_closed']")
    public WebElement totalRowElement;

    @FindBy(xpath= "//a[contains(text(),'Opportunity')]")
    public WebElement opportunityElement;

    @FindBy(css= "td:nth-of-type(2)")
    public WebElement revenueListElement;

    @FindBy(css= "tr:nth-of-type(1)>td:nth-of-type(2)")
    public WebElement pivotTotalElement;

    public By column2Element = By.cssSelector("tbody>tr>td:nth-of-type(2)");


    public PipelineRevenuePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public static String choseRandomRevenueFromList() {
        OpportunityPage opportunity=new OpportunityPage();
        nthRowOfTable = SeleniumUtils.randomInt(BriteErpUtilsOST.getCountOfRows(By.cssSelector("tbody>tr")));
        return (Driver.getDriver().findElement(By.cssSelector("tr:nth-child("+nthRowOfTable+") > td:nth-child(9)")).getText());
    }

    public static String choseRandomRevenueFromPivot() {
        return (Driver.getDriver().findElement(By.cssSelector("tr:nth-child("+(nthRowOfTable+2)+") > td:nth-child(2)")).getText());
    }






}
