package com.briteerp.tests.components.crm;

import com.briteerp.pages.CRM.OpportunityPage;
import com.briteerp.pages.CRM.PipelineRevenuePage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DecimalFormat;

public class PipelineRevenueTest extends TestBase {
    PipelineRevenuePage crmPipelineRev = new PipelineRevenuePage();
    int n = 0;
/*
Acceptance Criteria:
1.  Verify that second opportunity’ Expected Revenue value on the Pivot board should be the same
    as the Expected revenue column value on the list board.
*/

    @Test(priority = 1)
    public void PreConditionCreateOpportunity() {
        int NumOfNewOpportunities =3;
        extentLogger=report.createTest("Creating "+NumOfNewOpportunities+" new opportunities for precondition ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
//        SeleniumUtils.waitPlease(2);
        OpportunityPage.createOpportunity(NumOfNewOpportunities,4,4);
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.logout();
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
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(1);
        crmPipelineRev.totalRowElement.click();
        crmPipelineRev.opportunityElement.click();
        SeleniumUtils.waitPlease(1);

        extentLogger.info("Verification of Sum of Revenues");
        double SumOfRevenues = (BriteErpUtilsOST.getSumOfColumn(crmPipelineRev.column2Element))/3;
        DecimalFormat df = new DecimalFormat(".00");
        extentLogger.info("Verified that the Sum of Revenues  is $ "+df.format(SumOfRevenues));

        extentLogger.info("Verification of Total Revenue");
        double TotalRevenue = BriteErpUtilsOST.convertToDouble(crmPipelineRev.pivotTotalElement.getText());
        extentLogger.info("Verified that the Total Revenue is $ "+df.format(TotalRevenue));

        Assert.assertEquals(df.format(SumOfRevenues),df.format(TotalRevenue));
        BriteErpUtilsOST.logout();
        extentLogger.pass("Verified that the Sum of the Revenues is equal to Total Revenue");
    }

    /*
Acceptance Criteria:
2.  Verify that the pivot table total expected revenue should be same as the list table total expected revenue.

*/

    @Test(priority=3)
    public void verifyRevenues() {
        extentLogger=report.createTest("Verify Pivot-TotalRevenue equals List-TotalRevenue");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");

        extentLogger.info("Verification of Pivot-TotalRevenue");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(1);
        String PivotExpectedRevenue = crmPipelineRev.PivotTotalExpectedRevenueElement.getText();
        extentLogger.info("Verified that the Pivot-TotalRevenue is $ "+PivotExpectedRevenue);

        extentLogger.info("Verification of List-TotalRevenue");
        crmPipelineRev.listElement.click();
        String ListExpectedRevenue = crmPipelineRev.ListExpectedRevenueElement.getText();
        extentLogger.info("Verified that the List-TotalRevenue is $ "+ListExpectedRevenue);

        Assert.assertEquals(PivotExpectedRevenue,ListExpectedRevenue);
        BriteErpUtilsOST.logout();
        extentLogger.pass("Verified both numbers are equal");
    }
/*
    User story:
    The system should display the correct information for each opportunity on the view list
    page and the pivot table.
    Acceptance Criteria:
    1.Verify that second opportunity’ Expected Revenue value on the Pivot board should be the same
    as the Expected revenue column value on the list board.
*/

    @Test(priority=4)
    public void verifyNthOppurtunities() {
        extentLogger=report.createTest("Verify that Pivot Table Opportunity-Expected Revenue is the same as \nthe List Table Opportunity-Expected Revenue");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");

        extentLogger.info("Verification of the List Oportunity-Expected Revenue");
        crmPipelineRev.listElement.click();             SeleniumUtils.waitPlease(1);
        crmPipelineRev.headCustomerElement.click();     SeleniumUtils.waitPlease(1);
        String ListNumExpectedRevenue = PipelineRevenuePage.choseRandomRevenueFromList();
        extentLogger.info("Verified that the List "+PipelineRevenuePage.nthRowOfTable+". opportunity-Expected Revenue is $ "+ListNumExpectedRevenue);

        extentLogger.info("Verification of the Pivot Opportunity-Expected Revenue");
        crmPipelineRev.pivotElement.click();             SeleniumUtils.waitPlease(1);
        crmPipelineRev.totalRowElement.click();          SeleniumUtils.waitPlease(1);
        crmPipelineRev.opportunityElement.click();       SeleniumUtils.waitPlease(1);
        String PivotNthExpectedRevenue = PipelineRevenuePage.choseRandomRevenueFromPivot();
        extentLogger.info("Verified that the Pivot "+PipelineRevenuePage.nthRowOfTable+". opportunity-Expected Revenue is $ "+PivotNthExpectedRevenue);

        Assert.assertEquals(ListNumExpectedRevenue,PivotNthExpectedRevenue);
        BriteErpUtilsOST.logout();
        extentLogger.pass("Verified both numbers are equal");
    }



}
