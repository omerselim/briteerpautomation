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
    public void PreConditionCreateOpportunity2() {
        System.out.println("==============================\nPrecondition Creating Opportunities\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("PreConditionCreateOpportunity2"+(++n));
        OpportunityPage.createOpportunity(4,4,4);
        OpportunityPage.createOpportunity(3,5,4);
        OpportunityPage.createOpportunity(5,6,3);
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("PreConditionCreateOpportunity2"+(++n));
    }

    @Test(priority=2)
    public void verifyRevenues() {
        System.out.println("==============================\nProseding verifyRevenues Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("ScreenShoot"+(++n));
        String PivotExpectedRevenue = crmPipelineRev.PivotExpectedRevenueElement.getText();
        crmPipelineRev.listElement.click();
        String ListExpectedRevenue = crmPipelineRev.ListExpectedRevenueElement.getText();
        BriteErpUtilsOST.captureScreenShot("ScreenShoot"+(++n));
        System.out.println("Expected revenue from Pivot :"+PivotExpectedRevenue);
        System.out.println("Expected revenue from List :"+ListExpectedRevenue);
        Assert.assertTrue(PivotExpectedRevenue.equals(ListExpectedRevenue));
        Assert.assertEquals(PivotExpectedRevenue,ListExpectedRevenue);
    }
/*
Acceptance Criteria:
2.  Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’
    expected revenue.
*/
    @Test(priority=3)
    public void verifySumOfRevenues() throws IOException {
        System.out.println("==============================\nProseding verifySumOfRevenues Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        crmPipelineRev.totalRowElement.click();
        crmPipelineRev.opportunityElement.click();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.captureScreenShot("ScreenShoot"+(++n));
        DecimalFormat df = new DecimalFormat(".00");
        double CountedSumOfRevenue = (BriteErpUtilsOST.getSumOfColumn(crmPipelineRev.column2Element))/3;
        double SumOfRevenue = BriteErpUtilsOST.convertToDouble(crmPipelineRev.pivotTotalElement.getText());
        System.out.println("Sum of expected revenues from List \t:"+df.format(CountedSumOfRevenue));
        System.out.println("Total expected revenue \t\t\t\t:"+SumOfRevenue);
        Assert.assertEquals(df.format(CountedSumOfRevenue),df.format(SumOfRevenue));

    }


}
