package com.briteerp.tests.components.crm;

import com.briteerp.tests.pages.CRM.crmPipelineRevPage;
import com.briteerp.tests.pages.login.loginPage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class crmPipelineRevTest extends TestBase {
    crmPipelineRevPage crmPipelineRev = new crmPipelineRevPage();


    @Test
    public void verifyRevenues() {
        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        String PivotExpectedRevenue = crmPipelineRev.PivotExpectedRevenueElement.getText();
        crmPipelineRev.listElement.click();
        String ListExpectedRevenue = crmPipelineRev.ListExpectedRevenueElement.getText();
        Assert.assertTrue(PivotExpectedRevenue.equals(ListExpectedRevenue));
        Assert.assertEquals(PivotExpectedRevenue,ListExpectedRevenue);
    }

    @Test
    public void verifySumOfRevenues() {

        BriteErpUtilsOST.navigateToModule("CRM");
        crmPipelineRev.pivotElement.click();
        SeleniumUtils.waitPlease(2);
        crmPipelineRev.totalRowElement.click();
        crmPipelineRev.opportunityElement.click();
//        List<WebElement> revenues = crmPipelineRev.revenueListElement.;

//        Assert.assertTrue(PivotExpectedRevenue.equals(ListExpectedRevenue));
//        Assert.assertEquals(PivotExpectedRevenue,ListExpectedRevenue);
//        loginPage.logout();
    }


}
