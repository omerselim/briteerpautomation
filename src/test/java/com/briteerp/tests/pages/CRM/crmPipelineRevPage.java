package com.briteerp.tests.pages.CRM;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class crmPipelineRevPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Long.valueOf(ConfigurationReader.getProperty("explicitwait"))));

    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']")
    public WebElement pivotElement;

    @FindBy(xpath= "//tr[1]//td[2]")
    public WebElement PivotExpectedRevenueElement;

    @FindBy(css= "button[class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public WebElement listElement;

    @FindBy(css= "td[title='Expected Revenues']")
    public WebElement ListExpectedRevenueElement;

    @FindBy(css= "td[class='o_pivot_header_cell_closed']")
    public WebElement totalRowElement;

    @FindBy(xpath= "//a[contains(text(),'Opportunity')]")
    public WebElement opportunityElement;

    @FindBy(xpath= "//td[2]")
    public WebElement revenueListElement;

//    @FindBy(xpath= "//a[contains(text(),'Opportunity')]")
//    public WebElement opportunityElement;


    public crmPipelineRevPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
