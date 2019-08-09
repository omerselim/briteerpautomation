package com.briteerp.tests.components.crm;

import com.briteerp.pages.crm.OpportunityPage;
import com.briteerp.pages.crm.PipelineRevenuePage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.Pages;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DecimalFormat;

public class PipelineRevenueTest extends TestBase {
    Pages pages = new Pages();

    @Test(priority = 1)
    public void PreConditionCreateOpportunity() {
        int NumOfNewOpportunities =1;
        extentLogger=report.createTest("Creating "+NumOfNewOpportunities+" new opportunities for precondition ");
        pages.loginPage().login();                                  SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");               //SeleniumUtils.waitPlease(1);
        OpportunityPage.createOpportunity(NumOfNewOpportunities,4,3);   SeleniumUtils.waitPlease(1);
        pages.loginPage().logout();
        extentLogger.pass(NumOfNewOpportunities+" opportunit(y/ies) has/have been created.");
    }


/*
Acceptance Criteria:
2.  Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’
    expected revenue.
*/
    @Test(priority=2)
    public void verifySumOfRevenuesEqual() throws IOException {
        extentLogger=report.createTest("Verify that the Sum of Revenues is equal to the Total Revenue");
        pages.loginPage().login();                                      SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        pages.pipelineRevenuePage().pivotElement.click();               //SeleniumUtils.waitPlease(1);
        pages.pipelineRevenuePage().totalRowElement.click();            //SeleniumUtils.waitPlease(1);
        pages.pipelineRevenuePage().opportunityElement.click();         SeleniumUtils.waitPlease(1);

        extentLogger.info("Verification of Sum of Revenues");
        double SumOfRevenues = (BriteErpUtilsOST.getSumOfColumn(pages.pipelineRevenuePage().column2Element))/3;
        DecimalFormat df = new DecimalFormat(".00");
        extentLogger.info("Verified that the Sum of Revenues  is $ "+df.format(SumOfRevenues));

        extentLogger.info("Verification of Total Revenue");
        double TotalRevenue = BriteErpUtilsOST.convertToDouble(pages.pipelineRevenuePage().pivotTotalElement.getText());
        extentLogger.info("Verified that the Total Revenue is $ "+df.format(TotalRevenue));

        Assert.assertEquals(df.format(SumOfRevenues),df.format(TotalRevenue));
        pages.loginPage().logout();
        extentLogger.pass("Verified that the Sum of the Revenues is equal to Total Revenue");
    }

    /*
Acceptance Criteria:
2.  Verify that the pivot table total expected revenue should be same as the list table total expected revenue.

*/
    @Test(priority=3)
    public void verifyRevenues() {
        extentLogger=report.createTest("Verify Pivot-TotalRevenue equals List-TotalRevenue");
        pages.loginPage().login();                                      SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");

        extentLogger.info("Verification of Pivot-TotalRevenue");
        pages.pipelineRevenuePage().pivotElement.click();               SeleniumUtils.waitPlease(1);
        String PivotExpectedRevenue = pages.pipelineRevenuePage().PivotTotalExpectedRevenueElement.getText();
        extentLogger.info("Verified that the Pivot-TotalRevenue is $ "+PivotExpectedRevenue);

        extentLogger.info("Verification of List-TotalRevenue");
        pages.pipelineRevenuePage().listElement.click();
        String ListExpectedRevenue = pages.pipelineRevenuePage().ListExpectedRevenueElement.getText();
        extentLogger.info("Verified that the List-TotalRevenue is $ "+ListExpectedRevenue);

        Assert.assertEquals(PivotExpectedRevenue,ListExpectedRevenue);
        pages.loginPage().logout();
        extentLogger.pass("Verified both numbers are equal");
    }


/*
    Acceptance Criteria:
    1.Verify that second opportunity’ Expected Revenue value on the Pivot board should be the same
    as the Expected revenue column value on the list board.
*/

    @Test(priority=4)
    public void verifyNthOppurtunities() {
        extentLogger=report.createTest("Verify that Pivot Table Opportunity-Expected Revenue is the same as \nthe List Table Opportunity-Expected Revenue");
        pages.loginPage().login();                                      SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");

        extentLogger.info("Verification of the List Oportunity-Expected Revenue");
        pages.pipelineRevenuePage().listElement.click();                //SeleniumUtils.waitPlease(1);
        pages.pipelineRevenuePage().headCustomerElement.click();        SeleniumUtils.waitPlease(1);
        String ListNumExpectedRevenue = PipelineRevenuePage.choseRandomRevenueFromList();
        extentLogger.info("Verified that the List "+PipelineRevenuePage.nthRowOfTable+". opportunity-Expected Revenue is $ "+ListNumExpectedRevenue);

        extentLogger.info("Verification of the Pivot Opportunity-Expected Revenue");
        pages.pipelineRevenuePage().pivotElement.click();               //SeleniumUtils.waitPlease(1);
        pages.pipelineRevenuePage().totalRowElement.click();            //SeleniumUtils.waitPlease(1);
        pages.pipelineRevenuePage().opportunityElement.click();         SeleniumUtils.waitPlease(1);
        String PivotNthExpectedRevenue = PipelineRevenuePage.choseRandomRevenueFromPivot();
        extentLogger.info("Verified that the Pivot "+PipelineRevenuePage.nthRowOfTable+". opportunity-Expected Revenue is $ "+PivotNthExpectedRevenue);

        Assert.assertEquals(ListNumExpectedRevenue,PivotNthExpectedRevenue);
        pages.loginPage().logout();
        extentLogger.pass("Verified both numbers are equal");
    }
}
