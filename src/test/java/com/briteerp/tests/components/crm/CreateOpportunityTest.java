/*
1.  open URL    http://34.220.250.213/
    Should be able to access BriteERP log in page.
2.  Enter login credentials 1 - user names.  eventscrmmanager28@info.com
    Able to write credential 1 - valid username inside the box.
3.  Enter login credential 2 - valid password.  eventscrmmanager
    Able to write credential 2 - valid password inside the box, and able to login to the main page.
4.  Click on the CRM tab.
    Should be able to access CRM page.
5.
6.
7.
8.
9.
10.
11.

 */
package com.briteerp.tests.components.crm;
import com.briteerp.pages.CRM.OpportunityPage;
import com.briteerp.utilities.BriteErpUtilsOST;
import com.briteerp.utilities.SeleniumUtils;
import com.briteerp.utilities.TestBase;
import org.testng.annotations.Test;

public class CreateOpportunityTest extends TestBase {
    OpportunityPage opportunity = new OpportunityPage();

    @Test
    public void createNewOpportunity() {
        int NumOfNewOpportunities =10;
        extentLogger=report.createTest("Creating "+NumOfNewOpportunities+" new opportunities ");
        BriteErpUtilsOST.login();
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.navigateToModule("CRM");
        SeleniumUtils.waitPlease(2);
        OpportunityPage.createOpportunity(NumOfNewOpportunities,7,3);
        SeleniumUtils.waitPlease(2);
        BriteErpUtilsOST.logout();
        SeleniumUtils.waitPlease(2);
        extentLogger.pass(NumOfNewOpportunities+" opportunit(y/ies) has/have been created.");

    }


}
