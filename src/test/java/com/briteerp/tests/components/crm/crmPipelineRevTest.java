package com.briteerp.tests.components.crm;

import com.briteerp.pages.CRM.crmPipelineRevPage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class crmPipelineRevTest extends TestBase {
    crmPipelineRevPage crmPipelineRev = new crmPipelineRevPage();
/*
Acceptance Criteria:
1.  Verify that second opportunity’ Expected Revenue value on the Pivot board should be the same
    as the Expected revenue column value on the list board.
*/

    @Test
    public void verifyRevenues() {
        System.out.println("==============================\nProseding verifyRevenues Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        String PivotExpectedRevenue = crmPipelineRev.PivotExpectedRevenueElement.getText();
        crmPipelineRev.listElement.click();
        String ListExpectedRevenue = crmPipelineRev.ListExpectedRevenueElement.getText();
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
    @Test
    public void verifySumOfRevenues() throws IOException {
        System.out.println("==============================\nProseding verifySumOfRevenues Test\n------------------------------");
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        crmPipelineRev.totalRowElement.click();
        crmPipelineRev.opportunityElement.click();
        SeleniumUtils.waitPlease(2);
        int n = 0;
        BriteErpUtilsOST.captureScreenShot("ScreenShoot"+(++n));
        double CountedSumOfRevenue = (BriteErpUtilsOST.getSumOfColumn(crmPipelineRev.column2Element))/3;
        double SumOfRevenue = BriteErpUtilsOST.convertToDouble(crmPipelineRev.pivotTotalElement.getText());
        System.out.println("Sum of expected revenues from List :"+CountedSumOfRevenue);
        System.out.println("Total expected revenue :"+SumOfRevenue);
        Assert.assertEquals(CountedSumOfRevenue,SumOfRevenue);

    }


}
